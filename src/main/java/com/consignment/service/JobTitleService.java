package com.consignment.service;

import com.consignment.entity.JobTitle;
import com.consignment.repository.CommonRepository;
import com.consignment.repository.JobTitleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
@Component
public class JobTitleService extends CommonRepository<JobTitle, JobTitleRepository> {
    public JobTitleService(JobTitleRepository repo) {
        super(repo);

    }
    public List<JobTitle> findByStatus(Integer status){
        return repo.findByStatus(status);
    }
}
