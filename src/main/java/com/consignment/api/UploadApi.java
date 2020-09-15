package com.consignment.api;

import com.consignment.dto.ServiceResult;
import com.consignment.dto.UploadDTO;
import com.consignment.processor.UploadProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 13,2020
 */
@RestController
@RequestMapping("/api/consignment/upload")
@AllArgsConstructor
public class UploadApi {
    private UploadProcessor processor;
    @PostMapping("/images")
    public ResponseEntity<ServiceResult> uploadImage(@ModelAttribute UploadDTO uploadDTO){
        ServiceResult serviceResult = new ServiceResult();
        try{
            processor.uploadImage(uploadDTO);
            serviceResult.setData(uploadDTO);
        }catch (Exception e){
            return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(serviceResult);
    }
}
