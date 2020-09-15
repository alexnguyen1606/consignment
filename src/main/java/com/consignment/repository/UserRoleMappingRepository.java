package com.consignment.repository;

import com.consignment.entity.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
public interface UserRoleMappingRepository
    extends JpaRepository<UserRoleMapping, Long>, QuerydslPredicateExecutor<UserRoleMapping> {
    @Transactional
    void deleteByUserId(Long userId);
}
