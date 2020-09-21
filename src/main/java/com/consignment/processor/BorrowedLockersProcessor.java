package com.consignment.processor;

import com.consignment.common.Constant;
import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.entity.*;
import com.consignment.exception.BorrowedLockersException;
import com.consignment.mapper.BorrowedLockersMapper;
import com.consignment.mapper.CustomerMapper;
import com.consignment.security.MyUser;
import com.consignment.service.BorrowedLockersService;
import com.consignment.service.CustomerService;
import com.consignment.service.LoggingService;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@AllArgsConstructor
@Service
public class BorrowedLockersProcessor {
  private BorrowedLockersService service;
  private BorrowedLockersMapper mapper;
  private CustomerMapper customerMapper;
  private CustomerService customerService;
  private LoggingService loggingService;
  private final QBorrowedLockers Q = QBorrowedLockers.borrowedLockers;
  private final QCustomer customer = QCustomer.customer;
  private final QLockers lockers = QLockers.lockers;

  public synchronized void borrow(BorrowedLockersDTO borrowedLockersDTO)
      throws BorrowedLockersException {
    if (borrowedLockersDTO.getLockersId() == null) {
      throw new BorrowedLockersException("Không tìm thấy tủ đồ");
    }
    if (customerService.unExitsById(borrowedLockersDTO.getCustomerId())) {
      throw new BorrowedLockersException("Không tìm thấy thông tin khách hàng");
    }
    Customer customer = customerService.findById(borrowedLockersDTO.getCustomerId()).get();
    borrowedLockersDTO.setInsuranceCode(customer.getInsuranceCode());
    BorrowedLockers borrowedLockers = mapper.toEntity(borrowedLockersDTO);
    service.save(borrowedLockers);
    Logging logging = setLog(borrowedLockers);
    logging.setType(Constant.CHECK_IN);
    loggingService.save(logging);
  }

  @Transactional
  public synchronized void returnLockers(Long code) throws BorrowedLockersException {
    Optional<BorrowedLockers> borrowedLockersOptional = service.findById(code);
    if (!borrowedLockersOptional.isPresent()) {
      throw new BorrowedLockersException("Không có thông tin");
    }
    BorrowedLockers borrowedLockers = borrowedLockersOptional.get();
    service.delete(borrowedLockers);
    Logging logging = setLog(borrowedLockers);
    logging.setType(Constant.CHECK_OUT);
    loggingService.save(logging);
  }

  private Logging setLog(BorrowedLockers borrowedLockers) {
    Logging logging = new Logging();
    MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    logging.setUserId(myUser.getId());
    logging.setLockerId(borrowedLockers.getLockersId());
    logging.setCustomerId(borrowedLockers.getCustomerId());
    return logging;
  }

  public List<BorrowedLockersDTO> findAll(
      BorrowedLockersDTO borrowedLockersDTO, Pageable pageable) {
    BooleanBuilder builder = buildCommonBLBuilder(borrowedLockersDTO);
    List<BorrowedLockers> data = service.findAll(builder, pageable);
    return data.stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  public Long count(BorrowedLockersDTO borrowedLockers) {
    BooleanBuilder builder = buildCommonBLBuilder(borrowedLockers);
    return service.count(builder);
  }

  protected BooleanBuilder buildCommonBLBuilder(BorrowedLockersDTO borrowedLockers) {
    BooleanBuilder builder = new BooleanBuilder();
    if (borrowedLockers == null) {
      return builder;
    }
    if (StringUtils.isNotBlank(borrowedLockers.getTextSearch())) {
      String textSearch = borrowedLockers.getTextSearch();
      builder.and(
          Q.createdBy
              .containsIgnoreCase(textSearch)
              .or(customer.insuranceCode.contains(textSearch))
              .or(customer.numberIdentify.contains(textSearch)))
            .or(customer.fullName.containsIgnoreCase(textSearch));
    }
    if (borrowedLockers.getLockersId() != null) {
      builder.and(Q.lockersId.eq(borrowedLockers.getLockersId()));
    }

    return builder;
  }

  public BorrowedLockersDTO findById(Long id) throws BorrowedLockersException {
    Optional<BorrowedLockers> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new BorrowedLockersException("Không tìm thấy dữ liệu");
    }
    BorrowedLockers borrowedLockers = optional.get();
    return mapper.toDTO(borrowedLockers);
  }

  public Long count(){
    return service.count();
  }
}
