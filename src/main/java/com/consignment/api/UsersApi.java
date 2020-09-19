package com.consignment.api;

import com.consignment.dto.ServiceResult;
import com.consignment.dto.UsersDTO;
import com.consignment.exception.UserException;
import com.consignment.processor.UsersProcessor;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/consignment/user")
public class UsersApi {
  private UsersProcessor usersProcessor;

  @PostMapping
  public ResponseEntity<ServiceResult> create(@Valid @RequestBody UsersDTO usersDTO) {
    ServiceResult serviceResult = new ServiceResult("Tạo tài khoản thành công");
    try {
      usersProcessor.create(usersDTO);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataExp) {
      serviceResult.setMessage("Username đã tồn tại");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping
  public ResponseEntity<ServiceResult> update(@Valid @RequestBody UsersDTO usersDTO) {
    ServiceResult serviceResult = new ServiceResult("Cập nhật thông tin thành công");
    try {
      usersProcessor.update(usersDTO);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException dataExp) {
      serviceResult.setMessage("Username đã tồn tại");
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PostMapping("/all")
  public ResponseEntity<ServiceResult> findAll(
      @RequestBody UsersDTO usersDTO,
      @RequestParam(required = false, defaultValue = "1", name = "page") Integer currentPage,
      @RequestParam(required = false, defaultValue = "10") Integer size) {
    Pageable pageable = PageRequest.of(currentPage - 1, size, Sort.by("createdDate").descending());
    Long totalItem = usersProcessor.count(usersDTO);
    int totalPage = (int) Math.ceil((double) totalItem / size);
    List<UsersDTO> data = usersProcessor.findAll(usersDTO, pageable);
    ServiceResult serviceResult = new ServiceResult(data, totalPage, currentPage);
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/change-password")
  public ResponseEntity<ServiceResult> changePassword(@RequestBody UsersDTO usersDTO) {
    ServiceResult serviceResult = new ServiceResult("Đổi mật khẩu thành công");
    try {
      usersProcessor.changePassword(usersDTO);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/disable/{id}")
  public ResponseEntity<ServiceResult> disable(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      usersProcessor.disableUser(id);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/enable/{id}")
  public ResponseEntity<ServiceResult> enable(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      usersProcessor.enableUser(id);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/reset/{id}")
  public ResponseEntity<ServiceResult> resetPassword(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult("Reset mật khẩu thành công");
    try {
      usersProcessor.resetPassword(id);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ServiceResult> findById(@PathVariable Long id) {
    ServiceResult serviceResult = new ServiceResult();
    try {
      UsersDTO usersDTO = usersProcessor.findById(id);
      serviceResult.setData(usersDTO);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/roles")
  public ResponseEntity<ServiceResult> updateRole(@RequestBody UsersDTO usersDTO) {
    ServiceResult serviceResult = new ServiceResult();
    serviceResult.setMessage("Cập nhật thành công");
    try {
      usersProcessor.updateRole(usersDTO);
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
      return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(serviceResult, HttpStatus.OK);
  }

  @GetMapping("/info")
  public ResponseEntity<ServiceResult> getInfo() {
    ServiceResult serviceResult = new ServiceResult();
    try {
      serviceResult.setData(usersProcessor.getInfo());
    } catch (UserException e) {
      serviceResult.setMessage(e.getMessage());
    }
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/info")
  public ResponseEntity<ServiceResult> updateInfo(@RequestBody UsersDTO usersDTO) {
    ServiceResult serviceResult = new ServiceResult("Cập nhật thành công");
    usersProcessor.updateInfo(usersDTO);
    return ResponseEntity.ok(serviceResult);
  }

  @PutMapping("/avatar")
  public ResponseEntity<ServiceResult> updateAvatar(@RequestBody UsersDTO usersDTO) {
    usersProcessor.updateAvatar(usersDTO);
    return ResponseEntity.ok(new ServiceResult());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ServiceResult> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    ServiceResult serviceResult = new ServiceResult();
    StringBuilder errors = new StringBuilder();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              errors.append(error.getDefaultMessage()).append(" ");
            });
    serviceResult.setMessage(errors.toString());
    return new ResponseEntity<>(serviceResult, HttpStatus.BAD_REQUEST);
  }
}
