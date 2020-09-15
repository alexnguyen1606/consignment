package com.consignment.repository;

import com.consignment.entity.Lockers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
public interface LockersRepository
    extends JpaRepository<Lockers, Long>, QuerydslPredicateExecutor<Lockers> {
    List<Lockers> findByIsActive(Boolean status);
}
