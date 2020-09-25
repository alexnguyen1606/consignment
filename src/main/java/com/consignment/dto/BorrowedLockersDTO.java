package com.consignment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 09,2020
 */
@Data
public class BorrowedLockersDTO extends BaseDTO {


  @NotNull(message = "Ô cất trữ không được bỏ trống")
  private Long lockersId;

  private String note;

  private String insuranceCode;
  @NotNull(message = "Thông tin khách hàng không được bỏ trống")
  private Long customerId;

  private CustomerDTO customer;

  private UsersDTO user;

  private LockersDTO lockers;

  private LocalDate startTime;

  private LocalDate endTime;

  private String phoneNumber;


}
