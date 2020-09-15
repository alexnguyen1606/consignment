package com.consignment.service;

import com.consignment.entity.QRoles;
import com.consignment.entity.Roles;
import com.consignment.mapper.CommonMapper;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.RolesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 13,2020
 */
@Component
public class RolesService extends CommonRepository<Roles, RolesRepository> {
    public RolesService(RolesRepository repo) {
        super(repo);
    }
    private final QRoles Q = QRoles.roles;

    public List<Roles> findByListId(List<Long> ids){
        return repo.findByIdIn(ids);
    }
    public Roles findByCode(String code){
        return repo.findByCode(code);
    }
    public Optional<Roles> findById(Long id){
        return repo.findById(id);
    }
}
