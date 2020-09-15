package com.consignment.api;

import com.consignment.dto.ServiceResult;
import com.consignment.processor.RoleProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/consignment/role")
public class RoleApi {
  private RoleProcessor processor;

  @GetMapping("/user/{userId}")
  public ResponseEntity<ServiceResult> getRoleCheck(@PathVariable Long userId) {
    ServiceResult serviceResult = new ServiceResult();
    serviceResult.setData(processor.getRoleCheckByUserId(userId));
    return ResponseEntity.ok(serviceResult);
  }
}
