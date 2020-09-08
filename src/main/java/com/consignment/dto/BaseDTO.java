package com.consignment.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
public class BaseDTO {
  private Long id;

  private Date createdDate;

  private Date modifiedDate;

  private String createdBy;

  private String modifiedBy;
}
