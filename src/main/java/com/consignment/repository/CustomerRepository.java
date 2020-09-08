package com.consignment.repository;

import com.consignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
public interface CustomerRepository
    extends JpaRepository<Customer, Long>, QuerydslPredicateExecutor<Customer> {}
