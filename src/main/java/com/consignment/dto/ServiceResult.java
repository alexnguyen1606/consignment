package com.consignment.dto;

import lombok.Data;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
public class ServiceResult {
  private String code;
  private Object data;
  private String message;
  private Integer totalPage;
  private Integer currentPage;

  public ServiceResult() {}

  public ServiceResult(Object data, Integer totalPage, Integer currentPage) {
    this.data = data;
    this.totalPage = totalPage;
    this.currentPage = currentPage;
  }

  public ServiceResult(String message) {
    this.message = message;
  }
}
