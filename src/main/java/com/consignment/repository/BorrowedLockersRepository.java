package com.consignment.repository;

import com.consignment.entity.BorrowedLockers;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
public interface BorrowedLockersRepository
    extends JpaRepository<BorrowedLockers, Long>, QuerydslPredicateExecutor<BorrowedLockers> {
  Boolean existsByLockersId(Long lockersId);
  Optional<BorrowedLockers> findBorrowedLockersByInsuranceCode(String insurenceCode);
  List<BorrowedLockers> findByLockersId(Long lockersId);

}
