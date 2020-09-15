package com.consignment.mapper;

import com.consignment.dto.RolesDTO;
import com.consignment.entity.Roles;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-16T00:05:19+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class RolesMapperImpl implements RolesMapper {

    @Override
    public Roles toEntity(RolesDTO m) {
        if ( m == null ) {
            return null;
        }

        Roles roles = new Roles();

        roles.setId( m.getId() );
        roles.setCreatedDate( m.getCreatedDate() );
        roles.setModifiedDate( m.getModifiedDate() );
        roles.setCreatedBy( m.getCreatedBy() );
        roles.setModifiedBy( m.getModifiedBy() );
        roles.setCode( m.getCode() );
        roles.setName( m.getName() );
        roles.setDescription( m.getDescription() );

        return roles;
    }

    @Override
    public RolesDTO toDTO(Roles e) {
        if ( e == null ) {
            return null;
        }

        RolesDTO rolesDTO = new RolesDTO();

        rolesDTO.setId( e.getId() );
        rolesDTO.setCreatedDate( e.getCreatedDate() );
        rolesDTO.setModifiedDate( e.getModifiedDate() );
        rolesDTO.setCreatedBy( e.getCreatedBy() );
        rolesDTO.setModifiedBy( e.getModifiedBy() );
        rolesDTO.setCode( e.getCode() );
        rolesDTO.setName( e.getName() );
        rolesDTO.setDescription( e.getDescription() );

        return rolesDTO;
    }
}
