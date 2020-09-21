package com.consignment.api;

import com.consignment.dto.CabinetDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.CabinetException;
import com.consignment.processor.CabinetProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 21,2020
 */
@RestController
@RequestMapping("/api/cabinet")
@AllArgsConstructor
public class CabinetApi {
  private CabinetProcessor processor;

  @PostMapping
  public ResponseEntity<ServiceResult> create(@RequestBody CabinetDTO cabinetDTO) {
    ServiceResult serviceResult = new ServiceResult("Thêm thành công");
    try {
      processor.create(cabinetDTO);
    } catch (CabinetException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping
  public ResponseEntity<ServiceResult> update(@RequestBody CabinetDTO cabinetDTO) {
    ServiceResult serviceResult = new ServiceResult("Cập nhật thành công");
    try {
      processor.update(cabinetDTO);
    } catch (CabinetException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  

}
