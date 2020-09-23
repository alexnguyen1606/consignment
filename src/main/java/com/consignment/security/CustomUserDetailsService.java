package com.consignment.security;

import com.consignment.entity.Roles;
import com.consignment.entity.Users;
import com.consignment.repository.UserRepository;
import com.consignment.service.RolesService;
import com.consignment.service.UserRoleMappingService;
import com.consignment.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 *     <p>May 14,2020
 */
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

   private UserService userService;
   private RolesService rolesService;
   private UserRoleMappingService userRoleMappingService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Users> optional = userService.findByUsernameAndIsActive(username, true);
    if (!optional.isPresent()) {
      throw new UsernameNotFoundException("User not found");
    }
    Users userEntity = optional.get();
    List<Long> roleIds = userRoleMappingService.findRoleIdsByUserId(userEntity.getId());
    List<Roles> listRoles = rolesService.findByListId(roleIds);
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (Roles roles:listRoles){
      authorities.add(new SimpleGrantedAuthority(roles.getCode()));
    }
    MyUser myUserDetail =
        new MyUser(
            userEntity.getUsername(),
            userEntity.getPassword(),
            true,
            true,
            true,
            true,
            authorities);
    BeanUtils.copyProperties(userEntity, myUserDetail);

    myUserDetail.setId(userEntity.getId());

    return myUserDetail;
  }
}
