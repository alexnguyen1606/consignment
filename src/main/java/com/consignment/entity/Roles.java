package com.consignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Table
@Entity
@Data
public class Roles extends BaseEntity {
  @Column(unique = true)
  private String code;
  @Column(columnDefinition = "nvarchar(255)")
  private String name;

  @Column(columnDefinition = "nvarchar(500)")
  private String description;
}
