package com.consignment.service;

import com.consignment.entity.QUsers;
import com.consignment.entity.Users;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.UserRepository;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 08,2020
 */
@Service
public class UserService extends CommonRepository<Users, UserRepository> {
  private final QUsers Q = QUsers.users;

  public UserService(UserRepository repo) {
    super(repo);
  }
  @Transactional
  public void updateAllStatusByJob(Boolean status,Long jobTitleId){
      JPAUpdateClause update = new JPAUpdateClause(getEntityManager(),Q);
      update.set(Q.isActive,status);
      update.where(Q.jobTitleId.eq(jobTitleId));
      update.execute();
  }

  public Optional<Users> findByUsernameAndIsActive(String username, boolean status) {
    return repo.findByUsernameAndIsActive(username, status);
  }

  public Users findByUsername(String username) {
    return repo.findByUsername(username);
  }
}
