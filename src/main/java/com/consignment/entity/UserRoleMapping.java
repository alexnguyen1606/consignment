package com.consignment.entity;

import lombok.Data;

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
public class UserRoleMapping extends BaseEntity {
    private Long userId;
    private Long roleId;
}
