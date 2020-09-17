package com.consignment.mapper.resolver;

import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.dto.LockersDTO;
import com.consignment.entity.BorrowedLockers;
import com.consignment.entity.Lockers;
import com.consignment.mapper.BorrowedLockersMapper;
import com.consignment.service.BorrowedLockersService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 14,2020
 */
@AllArgsConstructor
@Component
public class LockersResolve {
    private BorrowedLockersService borrowedLockersService;
    private BorrowedLockersMapper borrowedLockersMapper;

    @ObjectFactory
    public LockersDTO resolve(Lockers lockers,@TargetType Class<LockersDTO> type){
        LockersDTO lockersDTO = new LockersDTO();
        Integer totalBorrowed = borrowedLockersService.findByLockersId(lockers.getId()).size();
        lockersDTO.setTotalBorrowed(totalBorrowed);
        return lockersDTO;
    }
}
