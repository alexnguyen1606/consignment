package com.consignment.api;

import com.consignment.dto.CustomerDTO;
import com.consignment.dto.ServiceResult;
import com.consignment.exception.CustomerException;
import com.consignment.processor.CustomerProcessor;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/consignment/customer")
public class CustomerApi extends ExceptionHandlerApi {
  private CustomerProcessor processor;

  @PostMapping
  public ResponseEntity<ServiceResult> create(@RequestBody CustomerDTO customerDTO) {
    ServiceResult serviceResult = new ServiceResult();
    try {
     customerDTO =  processor.create(customerDTO);
      serviceResult.setData(customerDTO);
    } catch (CustomerException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }catch (DataIntegrityViolationException dataException){
      serviceResult.setMessage("Thông tin mã bảo hiểm hoặc thẻ căn cước đã được sử dụng");
      return new ResponseEntity<>(serviceResult,HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/insurance")
  public ResponseEntity<ServiceResult> findByInsurance(
      @RequestParam(name = "code") String insurranceCode) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      CustomerDTO customer = processor.findByInsuranceCode(insurranceCode);
      serviceResult.setData(customer);
    } catch (CustomerException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/identification")
  public ResponseEntity<ServiceResult> findByNumIdentify(
      @RequestParam(name = "code") String insurranceCode) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      CustomerDTO customer = processor.findByNumIndentify(insurranceCode);
      serviceResult.setData(customer);
    } catch (CustomerException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }
}
