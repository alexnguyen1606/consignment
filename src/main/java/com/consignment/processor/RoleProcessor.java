package com.consignment.processor;

import com.consignment.dto.RolesDTO;
import com.consignment.entity.Roles;
import com.consignment.entity.UserRoleMapping;
import com.consignment.mapper.RolesMapper;
import com.consignment.service.RolesService;
import com.consignment.service.UserRoleMappingService;
import com.consignment.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 15,2020
 */
@AllArgsConstructor
@Service
public class RoleProcessor {
    private RolesService service;
    private UserRoleMappingService userRoleMappingService;
    private RolesMapper mapper;
    public List<RolesDTO> getRoleCheckByUserId(Long userId){
        List<Long> roleMappingList = userRoleMappingService.findRoleIdsByUserId(userId);
        List<Roles> listRole = service.findAll();
        List<RolesDTO> rolesDTOList = listRole.stream().map(mapper::toDTO).collect(Collectors.toList());
        for (RolesDTO rolesDTO : rolesDTOList){
            if(roleMappingList.contains(rolesDTO.getId())){
                rolesDTO.setChecked("checked");
            }
        }
        return rolesDTOList;
    }
}
