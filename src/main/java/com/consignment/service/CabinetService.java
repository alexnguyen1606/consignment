package com.consignment.service;

import com.consignment.entity.Cabinet;
import com.consignment.repository.CabinetRepository;
import com.consignment.repository.CommonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */

@Component
public class CabinetService extends CommonRepository<Cabinet, CabinetRepository> {
    public CabinetService(CabinetRepository repo) {
        super(repo);
    }
}
