package com.consignment.converter;

import com.consignment.dto.UserDTO;
import com.consignment.entity.Users;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */
@Mapper
@Component
public interface UserConverter extends CommonConverter<Users, UserDTO> {
    @Override
    Users toEntity(UserDTO userDTO);

    @Override
    UserDTO toDTO(Users users);
}
