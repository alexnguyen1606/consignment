package com.consignment.security;

import com.consignment.dto.UsersDTO;
import com.consignment.entity.Users;
import com.consignment.exception.UserException;
import com.consignment.processor.UsersProcessor;
import com.consignment.repository.UserRepository;
import com.consignment.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consignment/login")
@AllArgsConstructor
public class SecurityApi {


  private UsersProcessor usersProcessor;
  @PostMapping
  public UserModel getUserByUserName(@RequestBody UserModel userModel) throws UserException {
    UsersDTO userEntity = usersProcessor.findByUsernameAndIsActive(userModel.getUsername(), true);
    UserModel result = new UserModel();
    if (userEntity != null) {
      result.setCode("200");
      result.setUsername(userEntity.getUsername());
      result.setFullName(userEntity.getFullName());
      result.setId(String.valueOf(userEntity.getId()));
      result.setPassword(userEntity.getPassword());
      result.setRoles(userEntity.getRoles());

    } else {
      result.setCode("500");
    }
    return result;
  }
}
