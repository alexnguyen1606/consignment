package com.consignment.api;

import com.consignment.dto.BorrowedLockersDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.BorrowedLockersException;
import com.consignment.processor.BorrowedLockersProcessor;
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

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/consignment/borrowed-lockers")
public class BorrowedLockersApi extends ExceptionHandlerApi {
  private BorrowedLockersProcessor processor;
  private final Logger logger = LogManager.getLogger(BorrowedLockersApi.class);

  @PostMapping
  public ResponseEntity<ServiceResult> borrowLocker(
      @RequestBody BorrowedLockersDTO borrowedLockers) {
    ServiceResult serviceResult = new ServiceResult("Thêm thành công");
    try {
      processor.borrow(borrowedLockers);
    } catch (BorrowedLockersException e) {
      logger.warn(e.getMessage());
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataException) {
      logger.warn(dataException.getMessage());
      serviceResult.setMessage("Mã bảo hiểm hoặc sô thẻ căn cước đã được sử dụng");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      BorrowedLockersDTO borrowedLockersDTO = processor.findById(id);
      serviceResult.setData(borrowedLockersDTO);
    } catch (BorrowedLockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PostMapping("/all")
  public ResponseEntity<ServiceResult> findAll(
      @RequestBody BorrowedLockersDTO borrowedLockers,
      @RequestParam(required = false, defaultValue = "1", name = "page") Integer currentPage,
      @RequestParam(required = false, defaultValue = "10") Integer size) {
    Pageable pageable = PageRequest.of(currentPage - 1, size, Sort.by("createdDate").descending());
    Long totalItem = processor.count(borrowedLockers);
    int totalPage = (int) Math.ceil((double) totalItem / size);
    List<BorrowedLockersDTO> data = processor.findAll(borrowedLockers, pageable);
    ServiceResult serviceResult = new ServiceResult(data, totalPage, currentPage);
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ServiceResult> returnLockers(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult("Tra thẻ thành công");
    try {
      processor.returnLockers(id);
    } catch (BorrowedLockersException e) {
      logger.warn(e.getMessage());
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }


}
