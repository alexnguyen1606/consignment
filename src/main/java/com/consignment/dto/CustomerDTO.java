package com.consignment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
public class CustomerDTO extends BaseDTO {

  private String fullName;
  @NotNull private String insuranceCode;

  private String dob;
  @NotNull private String numberIdentify;

  private String address;

  private int gender;
  private String phoneNumber;
}
