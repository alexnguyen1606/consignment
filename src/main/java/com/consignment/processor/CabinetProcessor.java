package com.consignment.processor;

import com.consignment.dto.CabinetDTO;
import com.consignment.entity.Cabinet;
import com.consignment.entity.QCabinet;
import com.consignment.exception.CabinetException;
import com.consignment.mapper.CabinetMapper;
import com.consignment.service.CabinetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    service.save(cabinet);
  }
}
