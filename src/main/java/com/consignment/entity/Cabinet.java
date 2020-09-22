package com.consignment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
@Table
@Entity
@Data
public class Cabinet extends BaseEntity {
    @Column(columnDefinition = "nvarchar(255)",unique = true)
    private String nameCabinet;
    @Column(unique = true)
    private String cabinetCode;
    @Column(columnDefinition = "nvarchar(500)")
    private String description;
    private Integer status;
}
