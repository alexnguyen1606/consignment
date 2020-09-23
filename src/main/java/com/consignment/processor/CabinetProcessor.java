package com.consignment.processor;

import com.consignment.common.Constant;
import com.consignment.dto.CabinetDTO;
import com.consignment.entity.Cabinet;
import com.consignment.entity.QCabinet;
import com.consignment.exception.CabinetException;
import com.consignment.mapper.CabinetMapper;
import com.consignment.service.CabinetService;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 21,2020
 */
@AllArgsConstructor
@Service
public class CabinetProcessor {
  private CabinetService service;
  private CabinetMapper mapper;
  private final QCabinet Q = QCabinet.cabinet;

  public void create(CabinetDTO cabinetDTO) throws CabinetException {
    if (cabinetDTO.getId() != null) {
      throw new CabinetException("ID MUST BE NULL");
    }
    Cabinet cabinet = mapper.toEntity(cabinetDTO);
    service.save(cabinet);
  }

  public void update(CabinetDTO cabinetDTO) throws CabinetException {
    if (cabinetDTO.getId() == null) {
      throw new CabinetException("ID MUST NOT BE NULL");
    }
    Cabinet cabinet = mapper.toEntity(cabinetDTO);
    Cabinet cabinetInDB = service.findById(cabinet.getId()).get();

    service.save(cabinet);
  }

  public List<CabinetDTO> findAll(CabinetDTO cabinetDTO, Pageable pageable) {
    BooleanBuilder builder = buildPredicate(cabinetDTO);
    return service.findAll(builder, pageable).getContent().stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList());
  }

  private BooleanBuilder buildPredicate(CabinetDTO cabinetDTO) {
    BooleanBuilder builder = new BooleanBuilder();
    if (cabinetDTO == null) {
      return builder;
    }
    if (StringUtils.isNotBlank(cabinetDTO.getTextSearch())) {
      String textSearch = cabinetDTO.getTextSearch();
      builder.and(Q.nameCabinet.containsIgnoreCase(textSearch));
    }
    return builder;
  }

  public Long count(CabinetDTO cabinetDTO) {
    BooleanBuilder builder = buildPredicate(cabinetDTO);
    return service.count(builder);
  }

  public List<CabinetDTO> findAll() {
    List<Cabinet> listData = service.findAll();
    return listData.stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  public List<CabinetDTO> findCabinetForLockers() {
    return service.findByStatus(Constant.ENABLE).stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList());
  }

  public CabinetDTO findById(Long id) throws CabinetException {
    Optional<Cabinet> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new CabinetException("Không tìm thấy thông tin");
    }
    return mapper.toDTO(optional.get());
  }
}
