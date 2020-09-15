package com.consignment.dto;

import lombok.Data;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Data
public class RolesDTO extends BaseDTO {
  private String code;

  private String name;

  private String description;

  private String checked;
}
