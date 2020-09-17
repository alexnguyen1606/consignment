package com.consignment.mapper;

import com.consignment.dto.CustomerDTO;
import com.consignment.entity.Customer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-17T13:39:30+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDTO m) {
        if ( m == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( m.getId() );
        customer.setCreatedDate( m.getCreatedDate() );
        customer.setModifiedDate( m.getModifiedDate() );
        customer.setCreatedBy( m.getCreatedBy() );
        customer.setModifiedBy( m.getModifiedBy() );
        customer.setFullName( m.getFullName() );
        customer.setInsuranceCode( m.getInsuranceCode() );
        if ( m.getDob() != null ) {
            customer.setDob( LocalDate.parse( m.getDob() ) );
        }
        customer.setNumberIdentify( m.getNumberIdentify() );
        customer.setAddress( m.getAddress() );
        customer.setGender( m.getGender() );

        return customer;
    }

    @Override
    public CustomerDTO toDTO(Customer e) {
        if ( e == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( e.getId() );
        customerDTO.setCreatedDate( e.getCreatedDate() );
        customerDTO.setModifiedDate( e.getModifiedDate() );
        customerDTO.setCreatedBy( e.getCreatedBy() );
        customerDTO.setModifiedBy( e.getModifiedBy() );
        customerDTO.setFullName( e.getFullName() );
        customerDTO.setInsuranceCode( e.getInsuranceCode() );
        if ( e.getDob() != null ) {
            customerDTO.setDob( DateTimeFormatter.ISO_LOCAL_DATE.format( e.getDob() ) );
        }
        customerDTO.setNumberIdentify( e.getNumberIdentify() );
        customerDTO.setAddress( e.getAddress() );
        customerDTO.setGender( e.getGender() );

        return customerDTO;
    }
}
