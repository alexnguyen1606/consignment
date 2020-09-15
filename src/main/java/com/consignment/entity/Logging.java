package com.consignment.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Table
@Entity
@Data
public class Logging extends BaseEntity {
  private String type;
  private Long customerId;
  private Long userId;
  private Long lockerId;
}
