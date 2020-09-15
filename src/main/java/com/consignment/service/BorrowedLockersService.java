package com.consignment.service;

import com.consignment.entity.BorrowedLockers;
import com.consignment.entity.QBorrowedLockers;
import com.consignment.entity.QCustomer;
import com.consignment.repository.BorrowedLockersRepository;
import com.consignment.repository.CommonRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Service
public class BorrowedLockersService
    extends CommonRepository<BorrowedLockers, BorrowedLockersRepository> {
  public BorrowedLockersService(BorrowedLockersRepository repo) {
    super(repo);
  }

  private final QBorrowedLockers Q = QBorrowedLockers.borrowedLockers;
  private final QCustomer customer = QCustomer.customer;

  public Boolean exitByLockersId(Long lockersId) {
    return repo.existsByLockersId(lockersId);
  }

  public Optional<BorrowedLockers> findByInsuranceCode(String insuranceCode) {
    return repo.findBorrowedLockersByInsuranceCode(insuranceCode);
  }

  public List<BorrowedLockers> findByLockersId(Long lockersId){
    return repo.findByLockersId(lockersId);
  }

  public List<BorrowedLockers> findAll(BooleanBuilder builder, Pageable pageable) {
    JPAQuery<BorrowedLockers> query = new JPAQuery<>(getEntityManager());
    return query
        .from(Q)
        .innerJoin(customer)
        .on(Q.customerId.eq(customer.id))
        .where(builder)
        .limit(pageable.getPageSize())
        .offset(pageable.getOffset())
        .orderBy(Q.createdDate.desc())
        .fetch();
  }

  public Long count(BooleanBuilder builder) {
    JPAQuery<BorrowedLockers> query = new JPAQuery<>(getEntityManager());
    return query
        .from(Q)
        .innerJoin(customer)
        .on(Q.customerId.eq(customer.id))
        .where(builder)
        .fetchCount();
  }
}
