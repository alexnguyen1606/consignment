package com.consignment.repository;

import com.consignment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */
public interface UserRepository extends JpaRepository<Users,Long>, QuerydslPredicateExecutor<Users> {

    Optional<Users> findByUsernameAndIsActive(String username, Boolean isActive);
    Users findByUsername(String username);
}
