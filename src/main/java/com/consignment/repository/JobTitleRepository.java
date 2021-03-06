package com.consignment.repository;

import com.consignment.entity.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
public interface JobTitleRepository extends JpaRepository<JobTitle,Long>, QuerydslPredicateExecutor<JobTitle> {
    List<JobTitle> findByStatus(Integer status);
}
