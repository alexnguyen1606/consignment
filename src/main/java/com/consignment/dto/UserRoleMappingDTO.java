package com.consignment.dto;

import lombok.Data;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 12,2020
 */
@Data
public class UserRoleMappingDTO extends BaseDTO {
    private Long userId;
    private Long roleId;
    private String checked;
    private RolesDTO role;
}
