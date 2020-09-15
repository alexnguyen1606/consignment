package com.consignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
// Tủ đồ
@Data
@Table
@Entity
public class Lockers extends BaseEntity {
  @Column(columnDefinition = "nvarchar(255)")
  private String name;

  @Column(unique = true)
  private String code;

  @Column(columnDefinition = "nvarchar(500)")
  private String description;

  private Integer limit;
  private Boolean isActive = true;
}
