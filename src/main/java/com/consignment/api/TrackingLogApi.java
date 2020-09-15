package com.consignment.api;

import com.consignment.dto.LoggingDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.LockersException;
import com.consignment.processor.LoggingProcessor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 15,2020
 */
@RestController
@RequestMapping("/api/consignment/tracking-log")
@AllArgsConstructor
public class TrackingLogApi {
  private LoggingProcessor processor;

  @PostMapping("/all")
  public ResponseEntity<ServiceResult> findAll(
      @RequestBody LoggingDTO loggingDTO,
      @RequestParam(required = false, defaultValue = "1", name = "page") Integer currentPage,
      @RequestParam(required = false, defaultValue = "10") Integer size) {
    Pageable pageable = PageRequest.of(currentPage - 1, size, Sort.by("createdDate").descending());
    Long totalItem = processor.count(loggingDTO);
    int totalPage = (int) Math.ceil((double) totalItem / size);
    List<LoggingDTO> data = processor.findAll(loggingDTO, pageable);
    ServiceResult serviceResult = new ServiceResult(data, totalPage, currentPage);
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      LoggingDTO data = processor.findById(id);
      serviceResult.setData(data);
    } catch (LockersException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }

    return ResponseEntity.ok(serviceResult);
  }
}
