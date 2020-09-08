package com.consignment.service;

import com.consignment.entity.Users;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.UserRepository;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */
public class UserService extends CommonRepository<Users, UserRepository> {
    public UserService(UserRepository repo) {
        super(repo);
    }
}
