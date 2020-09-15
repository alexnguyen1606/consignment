package com.consignment.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
public class UsersDTO extends BaseDTO {
  @NotNull @NotBlank private String username;
  private String password;
  private Boolean isActive;
  private String email;
  private String fullName;
  private String passwordRepeated;
  private String passwordChange;
  private List<String> roles = new ArrayList<>();
  private String avatar;
}
