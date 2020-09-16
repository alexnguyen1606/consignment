package com.consignment.api;

import com.consignment.dto.ServiceResult;
import com.consignment.processor.BorrowedLockersProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 16,2020
 */
@RestController
@RequestMapping("/api/consignment/dashboard-info")
@AllArgsConstructor
public class DashboardController {
    private BorrowedLockersProcessor borrowedLockersProcessor;
    @GetMapping
    public ResponseEntity<ServiceResult> getInfo(){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(borrowedLockersProcessor.count());
        return ResponseEntity.ok(serviceResult);
    }
}
