package com.consignment.repository;

import com.consignment.entity.Logging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
public interface LoggingRepository
    extends JpaRepository<Logging, Long>, QuerydslPredicateExecutor<Logging> {}
