package com.consignment.mapper;

import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.entity.BorrowedLockers;
import com.consignment.mapper.resolver.BorrowedLockersResolver;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 09,2020
 */
@Mapper(uses = {BorrowedLockersResolver.class})
@Component
public interface BorrowedLockersMapper extends CommonMapper<BorrowedLockers, BorrowedLockersDTO> {

}
