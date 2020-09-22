package com.consignment.api;

import com.consignment.common.Constant;
import com.consignment.dto.JobTitleDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.JobTitleException;
import com.consignment.processor.JobTitleProcessor;
import lombok.AllArgsConstructor;
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
 *     <p>September 21,2020
 */
@RestController
@RequestMapping("/api/consignment/job-title")
@AllArgsConstructor
public class JobTitleApi {
  private JobTitleProcessor processor;

  @PostMapping
  public ResponseEntity<ServiceResult> create(@RequestBody JobTitleDTO jobTitle) {
    ServiceResult serviceResult = new ServiceResult("Thêm thành công");
    try {
      processor.create(jobTitle);
    } catch (JobTitleException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataException) {
      serviceResult.setMessage("Mã chức danh hoặc tên chức danh đã được sử dụng !");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping
  public ResponseEntity<ServiceResult> update(@RequestBody JobTitleDTO jobTitle) {
    ServiceResult serviceResult = new ServiceResult("Cập nhật thành công");
    try {
      processor.update(jobTitle);
    } catch (JobTitleException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataException) {
      serviceResult.setMessage("Mã chức danh hoặc tên chức danh đã được sử dụng !");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PostMapping("/all")
  public ResponseEntity<ServiceResult> findAll(
      @RequestBody JobTitleDTO jobTitle,
      @RequestParam(required = false, defaultValue = "1", name = "page") Integer currentPage,
      @RequestParam(required = false, defaultValue = "10") Integer size) {
    Pageable pageable = PageRequest.of(currentPage - 1, size, Sort.by("createdDate").descending());
    Long totalItem = processor.count(jobTitle);
    int totalPage = (int) Math.ceil((double) totalItem / size);
    List<JobTitleDTO> data = processor.findAll(jobTitle, pageable);
    ServiceResult serviceResult = new ServiceResult(data, totalPage, currentPage);
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      serviceResult.setData(processor.findById(id));
    } catch (JobTitleException e) {
      e.printStackTrace();
    }
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping
  public ResponseEntity<ServiceResult> getAll() {
    ServiceResult serviceResult = new ServiceResult();
    serviceResult.setData(processor.findByStatus(Constant.ENABLE));
    return ResponseEntity.ok(serviceResult);
  }
}
