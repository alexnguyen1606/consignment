package com.consignment.converter;

import com.consignment.dto.CustomerDTO;
import com.consignment.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */
@Mapper
@Component
public interface CustomerConverter extends CommonConverter<Customer, CustomerDTO>  {
    @Override
    Customer toEntity(CustomerDTO customerDTO);

    @Override
    CustomerDTO toDTO(Customer customer);
}
