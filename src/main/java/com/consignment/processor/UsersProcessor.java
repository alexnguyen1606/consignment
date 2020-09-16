package com.consignment.processor;

import com.consignment.dto.UsersDTO;
import com.consignment.entity.QUsers;
import com.consignment.entity.Roles;
import com.consignment.entity.UserRoleMapping;
import com.consignment.entity.Users;
import com.consignment.exception.UserException;
import com.consignment.mapper.UsersMapper;
import com.consignment.security.MyUser;
import com.consignment.service.RolesService;
import com.consignment.service.UserRoleMappingService;
import com.consignment.service.UserService;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@AllArgsConstructor
@Service
public class UsersProcessor {
  private UserService userService;
  private UsersMapper mapper;
  private final String DEFAULT_PASSWORD = "Abc12345";
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  private RolesService rolesService;
  private UserRoleMappingService roleMappingService;
  private final QUsers Q = QUsers.users;

  public void create(UsersDTO usersDTO) throws UserException {
    if (usersDTO.getId() != null) {
      throw new UserException("ID MUST BE NULL");
    }
    Users users = mapper.toEntity(usersDTO);
    String password = bCryptPasswordEncoder.encode(users.getPassword());
    if (StringUtils.isNotBlank(usersDTO.getPassword())) {
      password = bCryptPasswordEncoder.encode(usersDTO.getPassword());
    }
    users.setPassword(password);
    userService.save(users);
  }

  public void update(UsersDTO usersDTO) throws UserException {
    if (usersDTO.getId() == null) {
      throw new UserException("ID MUST NOT BE NULL");
    }
    Users users = mapper.toEntity(usersDTO);
    Optional<Users> usersOptional = userService.findById(usersDTO.getId());
    if (!usersOptional.isPresent()) {
      throw new UserException("Không tìm thấy tài khoản");
    }
    Users usersInDB = usersOptional.get();
    if (usersInDB.getUsername().equals("admin")) {
      users.setIsActive(true);
    }
    users.setUsername(usersInDB.getUsername());
    users.setCreatedBy(usersInDB.getCreatedBy());
    users.setCreatedDate(usersInDB.getCreatedDate());
    users.setPassword(usersInDB.getPassword());
    userService.save(users);
  }

  @Transactional
  public void updateRole(UsersDTO usersDTO) throws UserException {
    Optional<Users> optional = userService.findById(usersDTO.getId());
    if (!optional.isPresent()) {
      throw new UserException("Không tìm thấy thông tin");
    }
    roleMappingService.deleteByUserId(usersDTO.getId());
    List<UserRoleMapping> userRoleMappings = new ArrayList<>(5);
    for (String role : usersDTO.getRoles()) {
      Roles roles = rolesService.findByCode(role);
      UserRoleMapping userRoleMapping = new UserRoleMapping();
      userRoleMapping.setRoleId(roles.getId());
      userRoleMapping.setUserId(usersDTO.getId());
      userRoleMappings.add(userRoleMapping);
    }
    roleMappingService.saveAll(userRoleMappings);
  }

  @Transactional
  public void changePassword(UsersDTO usersDTO) throws UserException {
    boolean check = !usersDTO.getPasswordChange().equals(usersDTO.getPasswordRepeated());
    if (check) {
      throw new UserException("Mật khẩu không khớp");
    }
    MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Users users = userService.findByUsername(myUser.getUsername());
    boolean checkMatchPassword =
        !bCryptPasswordEncoder.matches(usersDTO.getPassword(), users.getPassword());
    if (checkMatchPassword) {
      throw new UserException("Mật khẩu không hợp lệ");
    }
    String passwordChange = bCryptPasswordEncoder.encode(usersDTO.getPasswordChange());
    users.setPassword(passwordChange);
    userService.save(users);
  }

  public void disableUser(Long id) throws UserException {
    Optional<Users> optional = userService.findById(id);
    if (!optional.isPresent()) {
      throw new UserException("Không tìm thấy thông tin người dùng");
    }
    Users users = optional.get();
    users.setIsActive(false);
    userService.save(users);
  }

  public void enableUser(Long id) throws UserException {
    Optional<Users> optional = userService.findById(id);
    if (!optional.isPresent()) {
      throw new UserException("Không tìm thấy thông tin người dùng");
    }
    Users users = optional.get();
    users.setIsActive(true);
    userService.save(users);
  }

  public UsersDTO findByUsernameAndIsActive(String username, boolean isActive)
      throws UserException {
    Optional<Users> optional = userService.findByUsernameAndIsActive(username, isActive);
    if (!optional.isPresent()) {
      throw new UserException("Không tìm thấy thông tin");
    }
    Users users = optional.get();
    UsersDTO usersDTO = mapper.toDTO(users);
    List<Long> listIdRole = roleMappingService.findRoleIdsByUserId(users.getId());
    List<Roles> roles = rolesService.findByListId(listIdRole);
    for (Roles role : roles) {
      usersDTO.getRoles().add(role.getCode());
    }
    return usersDTO;
  }

  public List<UsersDTO> findAll(UsersDTO usersDTO, Pageable pageable) {
    BooleanBuilder builder = commonBuilder(usersDTO);
    return userService.findAll(builder, pageable).getContent().stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList());
  }

  public Long count(UsersDTO usersDTO) {
    BooleanBuilder builder = commonBuilder(usersDTO);
    return userService.count(builder);
  }

  private BooleanBuilder commonBuilder(UsersDTO usersDTO) {
    BooleanBuilder builder = new BooleanBuilder();
    if (usersDTO == null) {
      return builder;
    }
    if (StringUtils.isNotBlank(usersDTO.getTextSearch())) {
      String textSearch = usersDTO.getTextSearch();
      builder.and(
          Q.username
              .containsIgnoreCase(textSearch)
              .or(Q.fullName.containsIgnoreCase(textSearch))
              .or(Q.email.containsIgnoreCase(textSearch)));
    }
    return builder;
  }

  public void resetPassword(Long id) throws UserException {
    Optional<Users> optional = userService.findById(id);
    if (!optional.isPresent()) {
      throw new UserException("Không tìm thấy thông tin người dùng");
    }
    Users user = optional.get();
    String password = bCryptPasswordEncoder.encode(DEFAULT_PASSWORD);
    user.setPassword(password);
    userService.save(user);
  }

  public UsersDTO findById(Long id) throws UserException {
    Optional<Users> optional = userService.findById(id);
    if (!optional.isPresent()) {
      throw new UserException("Không tìm thấy thông tin");
    }
    return mapper.toDTO(optional.get());
  }

  public UsersDTO getInfo() throws UserException {
    MyUser myUser= (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return findById(myUser.getId());
  }

  public void updateInfo(UsersDTO usersDTO) {
    MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Users users = userService.findById(myUser.getId()).get();
    users.setFullName(usersDTO.getFullName());
    users.setEmail(usersDTO.getEmail());
    userService.save(users);
  }

  public void updateAvatar(UsersDTO usersDTO) {
    MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Users users = userService.findById(myUser.getId()).get();
    users.setAvatar(usersDTO.getAvatar());
    userService.save(users);
  }
}
