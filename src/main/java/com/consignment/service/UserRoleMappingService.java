package com.consignment.service;

import com.consignment.entity.QUserRoleMapping;
import com.consignment.entity.UserRoleMapping;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.UserRoleMappingRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 13,2020
 */
@Component
public class UserRoleMappingService
    extends CommonRepository<UserRoleMapping, UserRoleMappingRepository> {
  public UserRoleMappingService(UserRoleMappingRepository repo) {
    super(repo);
  }

  private final QUserRoleMapping Q = QUserRoleMapping.userRoleMapping;

  public List<Long> findRoleIdsByUserId(Long userId) {
    JPAQuery<UserRoleMapping> query = new JPAQuery<>(getEntityManager());
    return query.select(Q.roleId).from(Q).where(Q.userId.eq(userId)).fetch();
  }

  public void deleteByUserId(Long userId){
    repo.deleteByUserId(userId);
  }

}
