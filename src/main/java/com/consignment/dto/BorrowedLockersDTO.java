package com.consignment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 09,2020
 */
@Data
public class BorrowedLockersDTO extends BaseDTO {


  @NotNull
  private Long lockersId;

  private String note;

  private String insuranceCode;
  @NotNull
  private Long customerId;

  private CustomerDTO customer;

  private UsersDTO user;

  private LockersDTO lockers;

}
