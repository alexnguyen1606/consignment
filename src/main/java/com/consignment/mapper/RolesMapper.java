package com.consignment.mapper;

import com.consignment.dto.RolesDTO;
import com.consignment.entity.Roles;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 12,2020
 */
@Mapper
@Component
public interface RolesMapper extends CommonMapper<Roles, RolesDTO> {
}
