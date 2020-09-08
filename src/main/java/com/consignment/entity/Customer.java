package com.consignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */
@Data
@Table
@Entity
public class Customer extends BaseEntity {
    @Column(columnDefinition = "nvarchar(255)")
    private String fullName;
    private String insuranceCode;
    private String dob;
    @Column(columnDefinition = "nvarchar(500)")
    private String address;
    private Integer gender;

}
