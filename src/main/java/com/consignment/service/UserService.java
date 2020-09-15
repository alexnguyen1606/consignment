package com.consignment.service;

import com.consignment.entity.Users;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 08,2020
 */
@Service
public class UserService extends CommonRepository<Users, UserRepository> {
    public UserService(UserRepository repo) {
        super(repo);

    }
    public Optional<Users> findByUsernameAndIsActive(String username, boolean status){
        return repo.findByUsernameAndIsActive(username,status);
    }

    public Users findByUsername(String username){
        return repo.findByUsername(username);
    }
}
