package com.consignment.api;

import com.consignment.dto.CabinetDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.CabinetException;
import com.consignment.processor.CabinetProcessor;
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
@RequestMapping("/api/consignment/cabinet")
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
    } catch (DataIntegrityViolationException dataException) {
      serviceResult.setMessage("Mã tủ hoặc tên đã được sử dụng !");
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
    } catch (DataIntegrityViolationException dataException) {
      serviceResult.setMessage("Mã tủ hoặc tên đã được sử dụng !");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }

    return ResponseEntity.ok(serviceResult);
  }

  @PostMapping("/all")
  public ResponseEntity<ServiceResult> findAll(
      @RequestBody CabinetDTO cabinetDTO,
      @RequestParam(required = false, defaultValue = "1", name = "page") Integer currentPage,
      @RequestParam(required = false, defaultValue = "10") Integer size) {
    Pageable pageable = PageRequest.of(currentPage - 1, size, Sort.by("createdDate").descending());
    Long totalItem = processor.count(cabinetDTO);
    int totalPage = (int) Math.ceil((double) totalItem / size);
    List<CabinetDTO> data = processor.findAll(cabinetDTO, pageable);
    ServiceResult serviceResult = new ServiceResult(data, totalPage, currentPage);
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping
  public ResponseEntity<ServiceResult> getAllForLock() {
    ServiceResult serviceResult = new ServiceResult();
    serviceResult.setData(processor.findCabinetForLockers());
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      serviceResult.setData(processor.findById(id));
    } catch (CabinetException e) {
      e.printStackTrace();
    }
    return ResponseEntity.ok(serviceResult);
  }
}
