package com.consignment.repository;

import com.consignment.entity.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
public interface CabinetRepository extends JpaRepository<Cabinet,Long>, QuerydslPredicateExecutor<Cabinet> {
    List<Cabinet> findByStatus(Integer status);
}
