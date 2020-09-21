package com.consignment.dto;

import lombok.Data;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 21,2020
 */
@Data
public class CabinetDTO extends BaseDTO {
  private String nameCabinet;
  private String description;
  private Integer status;
}
