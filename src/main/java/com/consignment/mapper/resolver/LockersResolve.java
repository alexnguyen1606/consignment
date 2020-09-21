package com.consignment.mapper.resolver;

import com.consignment.dto.CabinetDTO;
import com.consignment.dto.LockersDTO;
import com.consignment.entity.Lockers;
import com.consignment.mapper.CabinetMapper;
import com.consignment.service.BorrowedLockersService;
import com.consignment.service.CabinetService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 14,2020
 */
@AllArgsConstructor
@Component
public class LockersResolve {
  private BorrowedLockersService borrowedLockersService;
  private CabinetMapper cabinetMapper;
  private CabinetService cabinetService;

  @ObjectFactory
  public LockersDTO resolve(Lockers lockers, @TargetType Class<LockersDTO> type) {
    LockersDTO lockersDTO = new LockersDTO();
    Integer totalBorrowed = borrowedLockersService.findByLockersId(lockers.getId()).size();
    lockersDTO.setTotalBorrowed(totalBorrowed);
    if (lockers.getCabinetId() != null) {
      CabinetDTO cabinet =
          cabinetMapper.toDTO(cabinetService.findById(lockers.getCabinetId()).get());
      lockersDTO.setCabinet(cabinet);
    }
    return lockersDTO;
  }
}
