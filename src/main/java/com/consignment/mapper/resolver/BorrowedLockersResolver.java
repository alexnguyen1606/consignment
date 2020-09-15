package com.consignment.mapper.resolver;

import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.dto.CustomerDTO;
import com.consignment.dto.LockersDTO;
import com.consignment.dto.UsersDTO;
import com.consignment.entity.BorrowedLockers;
import com.consignment.mapper.CustomerMapper;
import com.consignment.mapper.LockersMapper;
import com.consignment.mapper.UsersMapper;
import com.consignment.service.CustomerService;
import com.consignment.service.LockersService;
import com.consignment.service.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Component
@AllArgsConstructor
public class BorrowedLockersResolver {
  private CustomerService customerService;
  private CustomerMapper customerMapper;
  private UserService userService;
  private UsersMapper usersMapper;
  private LockersService lockersService;
  private LockersMapper lockersMapper;

  @ObjectFactory
  public BorrowedLockersDTO resolve(
      BorrowedLockers borrowedLockers, @TargetType Class<BorrowedLockersDTO> type) {
    BorrowedLockersDTO borrowedLockersDTO = new BorrowedLockersDTO();
    CustomerDTO customerDTO =
        customerMapper.toDTO(customerService.findById(borrowedLockers.getCustomerId()).get());
    borrowedLockersDTO.setCustomer(customerDTO);
    UsersDTO users = usersMapper.toDTO(userService.findByUsername(borrowedLockers.getCreatedBy()));
    borrowedLockersDTO.setUser(users);
    LockersDTO lockers =
        lockersMapper.toDTO(lockersService.findById(borrowedLockers.getLockersId()).get());
    borrowedLockersDTO.setLockers(lockers);
    return borrowedLockersDTO;
  }
}
