package com.consignment.mapper.resolver;

import com.consignment.dto.CustomerDTO;
import com.consignment.dto.LockersDTO;
import com.consignment.dto.LoggingDTO;
import com.consignment.dto.UsersDTO;
import com.consignment.entity.Logging;
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
public class LoggingResolver {
  private CustomerService customerService;
  private CustomerMapper mapper;
  private UserService userService;
  private UsersMapper usersMapper;
  private LockersService lockersService;
  private LockersMapper lockersMapper;

  @ObjectFactory
  public LoggingDTO resolve(Logging logging, @TargetType Class<LoggingDTO> type) {
    LoggingDTO loggingDTO = new LoggingDTO();
    CustomerDTO customer = mapper.toDTO(customerService.findById(logging.getCustomerId()).get());
    loggingDTO.setCustomer(customer);
    UsersDTO user = usersMapper.toDTO(userService.findByUsername(logging.getCreatedBy()));
    loggingDTO.setUser(user);
    LockersDTO lockersDTO =
        lockersMapper.toDTO(lockersService.findById(logging.getLockerId()).get());
    loggingDTO.setLocker(lockersDTO);
    return loggingDTO;
  }
}
