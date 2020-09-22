package com.consignment.dto;

import com.consignment.validation.UsernamePattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
public class UsersDTO extends BaseDTO {
  @UsernamePattern(message = "Tên tài khoản không hợp lệ")
  private String username;

  private String password;
  private Boolean isActive;
  private String email;
  private String fullName;
  private String passwordRepeated;
  private String passwordChange;
  private List<String> roles = new LinkedList<>();
  private String avatar;
  private JobTitleDTO jobTitle;
  private Long jobTitleId;
  private String phoneNumber;
}
