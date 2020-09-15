package com.consignment.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
public abstract class BaseDTO {
  private Long id;

  private LocalDateTime createdDate;

  private LocalDateTime modifiedDate;

  private String createdBy;

  private String modifiedBy;

  private String textSearch;
}
