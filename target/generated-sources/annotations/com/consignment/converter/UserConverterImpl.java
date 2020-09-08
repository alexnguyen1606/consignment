package com.consignment.converter;

import com.consignment.dto.UserDTO;
import com.consignment.entity.Users;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-08T17:12:35+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public Users toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( userDTO.getId() );
        users.setCreatedDate( userDTO.getCreatedDate() );
        users.setModifiedDate( userDTO.getModifiedDate() );
        users.setCreatedBy( userDTO.getCreatedBy() );
        users.setModifiedBy( userDTO.getModifiedBy() );

        return users;
    }

    @Override
    public UserDTO toDTO(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( users.getId() );
        userDTO.setCreatedDate( users.getCreatedDate() );
        userDTO.setModifiedDate( users.getModifiedDate() );
        userDTO.setCreatedBy( users.getCreatedBy() );
        userDTO.setModifiedBy( users.getModifiedBy() );

        return userDTO;
    }
}
