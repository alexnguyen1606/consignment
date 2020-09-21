package com.consignment.service;

import com.consignment.dto.LockersDTO;
import com.consignment.entity.Lockers;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.LockersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Service
public class LockersService extends CommonRepository<Lockers, LockersRepository> {
  public LockersService(LockersRepository repo) {
    super(repo);
  }

  public List<Lockers> findByStatus(Boolean status) {
    return repo.findByIsActive(status);
  }

  public List<Lockers> findByCabinetIdAndStatus(Long cabinetId, Boolean enable) {
    return repo.findByCabinetIdAndIsActive(cabinetId,enable);
  }
}
