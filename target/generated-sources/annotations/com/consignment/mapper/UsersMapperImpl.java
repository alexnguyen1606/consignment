package com.consignment.mapper;

import com.consignment.dto.UsersDTO;
import com.consignment.entity.Users;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-16T00:05:18+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users toEntity(UsersDTO m) {
        if ( m == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( m.getId() );
        users.setCreatedDate( m.getCreatedDate() );
        users.setModifiedDate( m.getModifiedDate() );
        users.setCreatedBy( m.getCreatedBy() );
        users.setModifiedBy( m.getModifiedBy() );
        users.setUsername( m.getUsername() );
        users.setPassword( m.getPassword() );
        users.setIsActive( m.getIsActive() );
        users.setEmail( m.getEmail() );
        users.setFullName( m.getFullName() );
        users.setAvatar( m.getAvatar() );

        return users;
    }

    @Override
    public UsersDTO toDTO(Users e) {
        if ( e == null ) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setId( e.getId() );
        usersDTO.setCreatedDate( e.getCreatedDate() );
        usersDTO.setModifiedDate( e.getModifiedDate() );
        usersDTO.setCreatedBy( e.getCreatedBy() );
        usersDTO.setModifiedBy( e.getModifiedBy() );
        usersDTO.setUsername( e.getUsername() );
        usersDTO.setPassword( e.getPassword() );
        usersDTO.setIsActive( e.getIsActive() );
        usersDTO.setEmail( e.getEmail() );
        usersDTO.setFullName( e.getFullName() );
        usersDTO.setAvatar( e.getAvatar() );

        return usersDTO;
    }
}
