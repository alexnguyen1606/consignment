package com.consignment.processor;

import com.consignment.dto.CustomerDTO;
import com.consignment.entity.Customer;
import com.consignment.entity.QCustomer;
import com.consignment.exception.CustomerException;
import com.consignment.mapper.CustomerMapper;
import com.consignment.service.CustomerService;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@AllArgsConstructor
@Service
public class CustomerProcessor {
  private final QCustomer Q = QCustomer.customer;
  private CustomerService service;
  private CustomerMapper mapper;

  public CustomerDTO create(CustomerDTO customerDTO) throws CustomerException {
    if (customerDTO.getId() != null) {
      throw new CustomerException("Id đã có tồn tại");
    }
    Customer customer = mapper.toEntity(customerDTO);
    service.save(customer);
   return mapper.toDTO(customer);
  }

  public CustomerDTO findByNumIndentify(String code) throws CustomerException {
    Optional<Customer> optional = service.findByNumIdentify(code);
    if (!optional.isPresent()) {
      throw new CustomerException("Không tìm thấy");
    }
    Customer customer = optional.get();
    return mapper.toDTO(customer);
  }

  public CustomerDTO findByInsuranceCode(String insurancCode) throws CustomerException {
    Optional<Customer> optional = service.findByInsuranceCode(insurancCode);
    if (!optional.isPresent()) {
      throw new CustomerException("Không tìm thấy");
    }
    Customer customer = optional.get();
    return mapper.toDTO(customer);
  }

  private BooleanBuilder commonBuilder(CustomerDTO customerDTO) {
    BooleanBuilder builder = new BooleanBuilder();
    if (customerDTO == null) {
      return builder;
    }
    if (StringUtils.isNotBlank(customerDTO.getTextSearch())) {
      String textSearch = customerDTO.getTextSearch();
    }
    return builder;
  }
}
