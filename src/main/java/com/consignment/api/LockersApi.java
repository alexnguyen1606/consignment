package com.consignment.api;

import com.consignment.dto.LockersDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.entity.Lockers;
import com.consignment.exception.LockersException;
import com.consignment.processor.LockersProcessor;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/consignment/lockers")
public class LockersApi {
  private LockersProcessor processor;
  private final Logger logger = LogManager.getLogger(LockersApi.class);

  @PostMapping
  public ResponseEntity<ServiceResult> create(@Valid @RequestBody LockersDTO lockers) {
    ServiceResult serviceResult = new ServiceResult("Thêm thành công");
    try {
      processor.create(lockers);
    } catch (LockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataException) {
      logger.warn(dataException.getMessage());
      serviceResult.setMessage("Mã tủ đã được sử dụng");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping
  public ResponseEntity<ServiceResult> update(@Valid @RequestBody LockersDTO lockers) {
    ServiceResult serviceResult = new ServiceResult("Cập nhật thành công");
    try {
      processor.update(lockers);
    } catch (LockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataException) {
      logger.warn(dataException.getMessage());
      serviceResult.setMessage("Mã tủ đã được sử dụng");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/enable/{id}")
  public ResponseEntity<ServiceResult> enable(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      processor.enable(id);
    } catch (LockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/disable/{id}")
  public ResponseEntity<ServiceResult> disable(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      processor.disbale(id);
    } catch (LockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      LockersDTO lockersDTO = processor.findById(id);
      serviceResult.setData(lockersDTO);
    } catch (LockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PostMapping("/all")
  public ResponseEntity<ServiceResult> findAll(
      @RequestBody LockersDTO lockers,
      @RequestParam(required = false, defaultValue = "1", name = "page") Integer currentPage,
      @RequestParam(required = false, defaultValue = "10") Integer size) {
    Pageable pageable = PageRequest.of(currentPage - 1, size, Sort.by("createdDate").descending());
    Long totalItem = processor.count(lockers);
    int totalPage = (int) Math.ceil((double) totalItem / size);
    List<LockersDTO> data = processor.findAll(lockers, pageable);
    ServiceResult serviceResult = new ServiceResult(data, totalPage, currentPage);
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/search")
  public ResponseEntity<ServiceResult> findAll(@RequestParam String textSearch) {
    ServiceResult serviceResult = new ServiceResult();
    Iterable<Lockers> listData = processor.findAll(textSearch);
    serviceResult.setData(listData);
    return ResponseEntity.ok(serviceResult);
  }
  @GetMapping("/all")
  public ResponseEntity<ServiceResult> getAll() {
    ServiceResult serviceResult = new ServiceResult();
    List<LockersDTO> listData = processor.findByStatus(true);
    serviceResult.setData(listData);
    return ResponseEntity.ok(serviceResult);
  }
}
