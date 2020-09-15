package com.consignment.mapper.resolver;

import com.consignment.dto.RolesDTO;
import com.consignment.dto.UserRoleMappingDTO;
import com.consignment.entity.UserRoleMapping;
import com.consignment.mapper.RolesMapper;
import com.consignment.service.RolesService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 15,2020
 */
@Component
@AllArgsConstructor
public class UserRoleMappingResolve {
    private RolesService rolesService;
    private RolesMapper rolesMapper;

    @ObjectFactory
    private UserRoleMappingDTO resolve(UserRoleMapping userRoleMapping,Class<UserRoleMappingDTO> type){
        UserRoleMappingDTO userRoleMappingDTO = new UserRoleMappingDTO();
        RolesDTO rolesDTO = rolesMapper.toDTO(rolesService.findById(userRoleMapping.getRoleId()).get());
        userRoleMappingDTO.setRole(rolesDTO);
        return userRoleMappingDTO;
    }
}
