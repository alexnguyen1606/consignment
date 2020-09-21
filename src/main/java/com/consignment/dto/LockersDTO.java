package com.consignment.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Data
public class LockersDTO extends BaseDTO {
  @NotNull private String name;
  @NotNull @NotBlank private String code;
  private String description;
  private Boolean isActive;
  private Integer totalBorrowed;
  @NotNull(message = "Mã tủ đựng không được để trống")
  private Long cabinetId;
  private CabinetDTO cabinet;
}
