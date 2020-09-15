package com.consignment.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Data
@Table
@Entity
@EntityListeners(AuditingEntityListener.class)
public class BorrowedLockers extends BaseEntity {

  private Long lockersId;

  @Column(columnDefinition = "nvarchar(500)")
  private String note;

  @Column(unique = true)
  private String insuranceCode;

  @Column(unique = true)
  private Long customerId;
}
