package com.consignment.mapper;

import com.consignment.dto.UserRoleMappingDTO;
import com.consignment.entity.UserRoleMapping;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-17T13:39:30+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class UserRoleMappingMapperImpl implements UserRoleMappingMapper {

    @Override
    public UserRoleMapping toEntity(UserRoleMappingDTO m) {
        if ( m == null ) {
            return null;
        }

        UserRoleMapping userRoleMapping = new UserRoleMapping();

        userRoleMapping.setId( m.getId() );
        userRoleMapping.setCreatedDate( m.getCreatedDate() );
        userRoleMapping.setModifiedDate( m.getModifiedDate() );
        userRoleMapping.setCreatedBy( m.getCreatedBy() );
        userRoleMapping.setModifiedBy( m.getModifiedBy() );
        userRoleMapping.setUserId( m.getUserId() );
        userRoleMapping.setRoleId( m.getRoleId() );

        return userRoleMapping;
    }

    @Override
    public UserRoleMappingDTO toDTO(UserRoleMapping e) {
        if ( e == null ) {
            return null;
        }

        UserRoleMappingDTO userRoleMappingDTO = new UserRoleMappingDTO();

        userRoleMappingDTO.setId( e.getId() );
        userRoleMappingDTO.setCreatedDate( e.getCreatedDate() );
        userRoleMappingDTO.setModifiedDate( e.getModifiedDate() );
        userRoleMappingDTO.setCreatedBy( e.getCreatedBy() );
        userRoleMappingDTO.setModifiedBy( e.getModifiedBy() );
        userRoleMappingDTO.setUserId( e.getUserId() );
        userRoleMappingDTO.setRoleId( e.getRoleId() );

        return userRoleMappingDTO;
    }
}
