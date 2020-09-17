package com.consignment.mapper;

import com.consignment.dto.UserRoleMappingDTO;
import com.consignment.entity.UserRoleMapping;
import com.consignment.mapper.resolver.UserRoleMappingResolve;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */

@Component
@Mapper(uses = {UserRoleMappingResolve.class})
public interface UserRoleMappingMapper extends CommonMapper<UserRoleMapping, UserRoleMappingDTO> {}
