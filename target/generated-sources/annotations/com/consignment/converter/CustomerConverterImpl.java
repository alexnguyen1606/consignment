package com.consignment.converter;

import com.consignment.dto.CustomerDTO;
import com.consignment.entity.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-08T17:12:34+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class CustomerConverterImpl implements CustomerConverter {

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setCreatedDate( customerDTO.getCreatedDate() );
        customer.setModifiedDate( customerDTO.getModifiedDate() );
        customer.setCreatedBy( customerDTO.getCreatedBy() );
        customer.setModifiedBy( customerDTO.getModifiedBy() );

        return customer;
    }

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setCreatedDate( customer.getCreatedDate() );
        customerDTO.setModifiedDate( customer.getModifiedDate() );
        customerDTO.setCreatedBy( customer.getCreatedBy() );
        customerDTO.setModifiedBy( customer.getModifiedBy() );

        return customerDTO;
    }
}
