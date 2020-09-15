package com.consignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@SpringBootApplication
@ServletComponentScan
public class ApplicationConsignmentItemApi {
  public static void main(String[] args) {
    SpringApplication.run(ApplicationConsignmentItemApi.class, args);
  }
}
