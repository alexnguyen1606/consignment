package com.consignment.mapper;

import com.consignment.dto.UsersDTO;
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
public interface UsersMapper extends CommonMapper<Users, UsersDTO> {

}
