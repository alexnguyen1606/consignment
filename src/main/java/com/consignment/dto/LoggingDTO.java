package com.consignment.dto;

import lombok.Data;

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
}
