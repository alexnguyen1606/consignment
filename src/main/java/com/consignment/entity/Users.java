package com.consignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Table
@Entity
@Setter
@Getter
public class Users extends BaseEntity {
  @Column(unique = true)
  private String username;

  private String password;
  private Boolean isActive;
  private String email;

  @Column(columnDefinition = "nvarchar(255)")
  private String fullName;

  @Column(columnDefinition = "varchar(500)")
  private String avatar;

  private Long jobTitleId;

  private String phoneNumber;
}
