package com.consignment.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Data
public class LoggingDTO extends BaseDTO {
  private Long customerId;
  private CustomerDTO customer;
  private String type;
  private UsersDTO user;
  private Long lockerId;
  private LockersDTO locker;
  private LocalDate startTime;
  private LocalDate endTime;
  private String phoneNumber;

}
