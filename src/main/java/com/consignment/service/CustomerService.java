package com.consignment.service;

import com.consignment.entity.Customer;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 12,2020
 */
@Component
public class CustomerService extends CommonRepository<Customer, CustomerRepository> {
    public CustomerService(CustomerRepository repo) {
        super(repo);

    }

    public Optional<Customer> findByInsuranceCode(String code){
        return repo.findByInsuranceCode(code);
    }

    public Optional<Customer> findByNumIdentify(String numberIdentify){
        return repo.findByNumberIdentify(numberIdentify);
    }

    public Boolean exitsById(Long id){
        return repo.existsById(id);
    }

    public Boolean unExitsById(Long id){
        return !repo.existsById(id);
    }


}
