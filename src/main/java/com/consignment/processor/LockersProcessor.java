package com.consignment.processor;

import com.consignment.dto.LockersDTO;
import com.consignment.entity.Lockers;
import com.consignment.entity.QLockers;
import com.consignment.exception.LockersException;
import com.consignment.mapper.LockersMapper;
import com.consignment.service.LockersService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Service
@AllArgsConstructor
public class LockersProcessor {
  private final QLockers Q = QLockers.lockers;
  private LockersService service;
  private LockersMapper mapper;

  public void create(LockersDTO lockersDTO) throws LockersException {
    if (lockersDTO.getId() != null) {
      throw new LockersException("Thêm không thành công");
    }
    Lockers lockers = mapper.toEntity(lockersDTO);
    service.save(lockers);
  }

  public void update(LockersDTO lockersDTO) throws LockersException {
    if (lockersDTO.getId() == null) {
      throw new LockersException("Cập nhật không thành công");
    }
    Optional<Lockers> optional = service.findById(lockersDTO.getId());
    if (!optional.isPresent()) {
      throw new LockersException("Không tìm thấy tủ đồ");
    }
    Lockers lockers = mapper.toEntity(lockersDTO);
    Lockers lockersInDB = optional.get();
    lockers.setCreatedBy(lockersInDB.getCreatedBy());
    lockers.setCreatedDate(lockersInDB.getCreatedDate());
    service.save(lockers);
  }

  public List<LockersDTO> findAll(LockersDTO lockers, Pageable pageable) {
    BooleanBuilder builder = commonBuilder(lockers);
    List<Lockers> data = service.findAll(builder, pageable).getContent();
    return data.stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  public Long count(LockersDTO lockersDTO) {
    BooleanBuilder builder = commonBuilder(lockersDTO);
    return service.count(builder);
  }

  @CachePut(value = "lockers", key = "#textSearch")
  public Iterable<Lockers> findAll(String textSearch) {
    LockersDTO lockersDTO = new LockersDTO();
    lockersDTO.setTextSearch(textSearch);
    BooleanBuilder builder = commonBuilder(lockersDTO);
    return service.findAll(builder);
  }

  public List<LockersDTO> findAll() {
    return service.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  public List<LockersDTO> findByStatus(Boolean status) {
    return service.findByStatus(status).stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  @Transactional
  public void enable(Long id) throws LockersException {
    Optional<Lockers> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new LockersException("Không tìm thấy thông tin");
    }
    Lockers lockers = optional.get();
    JPAUpdateClause update = new JPAUpdateClause(service.getEntityManager(), Q);
    update.set(Q.isActive, true);
    update.where(Q.id.eq(lockers.getId()));
    update.execute();
  }

  @Transactional
  public void disbale(Long id) throws LockersException {
    Optional<Lockers> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new LockersException("Không tìm thấy thông tin");
    }
    Lockers lockers = optional.get();
    JPAUpdateClause update = new JPAUpdateClause(service.getEntityManager(), Q);
    update.set(Q.isActive, false);
    update.where(Q.id.eq(lockers.getId()));
    update.execute();
  }

  private BooleanBuilder commonBuilder(LockersDTO lockers) {
    BooleanBuilder builder = new BooleanBuilder();
    if (lockers == null) {
      return builder;
    }
    if (StringUtils.isNotBlank(lockers.getTextSearch())) {
      String textSearch = lockers.getTextSearch();
      builder.and(Q.name.containsIgnoreCase(textSearch).or(Q.code.containsIgnoreCase(textSearch)));
    }
    if (lockers.getIsActive()!=null){
      builder.and(Q.isActive.eq(lockers.getIsActive()));
    }
    return builder;
  }

  public LockersDTO findById(Long id) throws LockersException {
    Optional<Lockers> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new LockersException("Không tìm thấy hộp");
    }
    return mapper.toDTO(optional.get());
  }
}
