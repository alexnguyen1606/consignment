package com.consignment.api;

import com.consignment.common.Constant;

import java.time.LocalDateTime;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 18,2020
 */
public class Test {
  public static void main(String[] args) {
      LocalDateTime localDateTime = LocalDateTime.now(Constant.zoneId);
    System.out.println(localDateTime);
  }
}
