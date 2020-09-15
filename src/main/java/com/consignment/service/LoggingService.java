package com.consignment.service;

import com.consignment.entity.Logging;
import com.consignment.entity.QCustomer;
import com.consignment.entity.QLogging;
import com.consignment.entity.QUsers;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.LoggingRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Component
public class LoggingService extends CommonRepository<Logging, LoggingRepository> {

  private final QLogging Q = QLogging.logging;
  private final QCustomer customer = QCustomer.customer;
  private final QUsers user = QUsers.users;

  public LoggingService(LoggingRepository repo) {
    super(repo);
  }

  public List<Logging> findAll(BooleanBuilder booleanBuilder, Pageable pageable) {
    JPAQuery<Logging> query = new JPAQuery<>(getEntityManager());
    return query
        .select(Q)
        .from(Q)
        .innerJoin(customer)
        .on(customer.id.eq(Q.customerId))
        .innerJoin(user)
        .on(user.id.eq(Q.userId))
        .where(booleanBuilder)
        .limit(pageable.getPageSize())
        .offset(pageable.getOffset())
        .orderBy(Q.createdDate.desc())
        .fetch();
  }

  public Long count(BooleanBuilder booleanBuilder) {
    JPAQuery<Logging> query = new JPAQuery<>(getEntityManager());
    return query
        .select(Q)
        .from(Q)
        .innerJoin(customer)
        .on(customer.id.eq(Q.customerId))
        .innerJoin(user)
        .on(user.id.eq(Q.userId))
        .where(booleanBuilder)
        .fetchCount();
  }
}
