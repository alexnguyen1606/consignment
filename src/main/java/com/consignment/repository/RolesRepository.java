package com.consignment.repository;

import com.consignment.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 12,2020
 */
public interface RolesRepository extends JpaRepository<Roles,Long>, QuerydslPredicateExecutor<Roles> {
    List<Roles> findByIdIn(List<Long> ids);
    Roles findByCode(String code);
}
