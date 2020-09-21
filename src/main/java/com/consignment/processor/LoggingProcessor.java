package com.consignment.processor;

import com.consignment.dto.LoggingDTO;
import com.consignment.entity.*;
import com.consignment.exception.LockersException;
import com.consignment.mapper.LoggingMapper;
import com.consignment.service.LoggingService;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Service
@AllArgsConstructor
public class LoggingProcessor {
  private final QLogging Q = QLogging.logging;
  private LoggingService service;
  private LoggingMapper mapper;
  private final QCustomer customer = QCustomer.customer;
  private final QUsers user = QUsers.users;
  private final QLockers locker = QLockers.lockers;

  public List<LoggingDTO> findAll(LoggingDTO loggingDTO, Pageable pageable) {
    BooleanBuilder builder = commonBuilder(loggingDTO);
    List<Logging> listData = service.findAll(builder, pageable);
    return listData.stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  public Long count(LoggingDTO loggingDTO) {
    BooleanBuilder builder = commonBuilder(loggingDTO);
    return service.count(builder);
  }

  private BooleanBuilder commonBuilder(final LoggingDTO loggingDTO) {
    BooleanBuilder builder = new BooleanBuilder();
    if (loggingDTO == null) {
      return builder;
    }
    if (StringUtils.isNotBlank(loggingDTO.getTextSearch())) {
      String textSearch = loggingDTO.getTextSearch();
      builder.and(
          customer
              .insuranceCode
              .containsIgnoreCase(textSearch)
              .or(customer.numberIdentify.containsIgnoreCase(textSearch))
              .or(customer.fullName.containsIgnoreCase(textSearch)));
    }
    if (StringUtils.isNotBlank(loggingDTO.getType())) {
      builder.and(Q.type.eq(loggingDTO.getType()));
    }
    if (loggingDTO.getLockerId() != null) {
      builder.and(Q.lockerId.eq(loggingDTO.getLockerId()));
    }
    if (loggingDTO.getStartTime()!=null){
      builder.and(Q.createdDate.after(loggingDTO.getStartTime().atStartOfDay()));
    }
    if (loggingDTO.getEndTime()!= null){
      builder.and(Q.createdDate.before(loggingDTO.getEndTime().atStartOfDay().plusDays(1)));
    }
    return builder;
  }

  public LoggingDTO findById(Long id) throws LockersException {
    Optional<Logging> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new LockersException("Không tìm thấy thông tin");
    }
    Logging logging = optional.get();
    return mapper.toDTO(logging);
  }
}
