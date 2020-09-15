package com.consignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
@Table
@Entity
public class Customer extends BaseEntity {
  @Column(columnDefinition = "nvarchar(255)")
  private String fullName;

  @Column(unique = true)
  private String insuranceCode;

  private LocalDate dob;

  @Column(unique = true)
  private String numberIdentify;

  @Column(columnDefinition = "nvarchar(500)")
  private String address;

  private int gender ;

}
