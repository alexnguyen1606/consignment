package com.consignment.api;

import com.consignment.dto.JobTitleDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.JobTitleException;
import com.consignment.processor.JobTitleProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    }
    return ResponseEntity.ok(serviceResult);
  }
}
