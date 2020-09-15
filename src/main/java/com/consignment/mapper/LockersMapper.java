package com.consignment.mapper;

import com.consignment.dto.LockersDTO;
import com.consignment.entity.Lockers;
import com.consignment.mapper.resolver.LockersResolve;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Mapper(uses = LockersResolve.class)
@Component
public interface LockersMapper extends CommonMapper<Lockers, LockersDTO> {

}
