package com.consignment.processor;

import com.consignment.dto.JobTitleDTO;
import com.consignment.entity.JobTitle;
import com.consignment.entity.QJobTitle;
import com.consignment.exception.JobTitleException;
import com.consignment.mapper.JobTitleMapper;
import com.consignment.service.JobTitleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 21,2020
 */
@Service
@AllArgsConstructor
public class JobTitleProcessor {
  private JobTitleService service;
  private JobTitleMapper mapper;
  private final QJobTitle Q = QJobTitle.jobTitle;

  public void create(JobTitleDTO jobTitleDTO) throws JobTitleException {
    if (jobTitleDTO.getId() != null) {
      throw new JobTitleException("Id must be null");
    }
    JobTitle jobTitle = mapper.toEntity(jobTitleDTO);
    service.save(jobTitle);
  }

  public void update(JobTitleDTO jobTitleDTO) throws JobTitleException {
      if (jobTitleDTO.getId()==null){
          throw new JobTitleException("ID MUST BE NULL");
      }
      JobTitle jobTitle = mapper.toEntity(jobTitleDTO);
      service.save(jobTitle);
  }


}
