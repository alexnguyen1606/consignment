package com.consignment.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserModel {
  private String fullName;
  private String id;
  private String code;
  @NotNull private String username;
  @NotNull private String password;
  private Integer status;
  private List<String> roles;
}
