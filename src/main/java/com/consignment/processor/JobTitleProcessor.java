package com.consignment.processor;

import com.consignment.dto.JobTitleDTO;
import com.consignment.entity.JobTitle;
import com.consignment.entity.QJobTitle;
import com.consignment.exception.JobTitleException;
import com.consignment.mapper.JobTitleMapper;
import com.consignment.service.JobTitleService;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    if (jobTitleDTO.getId() == null) {
      throw new JobTitleException("ID MUST BE NULL");
    }
    JobTitle jobTitle = mapper.toEntity(jobTitleDTO);
    service.save(jobTitle);
  }

  public JobTitleDTO findById(Long id) throws JobTitleException {
    Optional<JobTitle> optional = service.findById(id);
    if (!optional.isPresent()) {
      throw new JobTitleException("Không tìm thấy thông tin");
    }
    return mapper.toDTO(optional.get());
  }

  public List<JobTitleDTO> findAll(JobTitleDTO jobTitleDTO, Pageable pageable) {
    BooleanBuilder builder = buildPredicate(jobTitleDTO);
    return service.findAll(builder, pageable).getContent().stream()
        .map(mapper::toDTO)
        .collect(Collectors.toList());
  }

  public Long count(JobTitleDTO jobTitleDTO) {
    BooleanBuilder builder = buildPredicate(jobTitleDTO);
    return service.count(builder);
  }

  public List<JobTitleDTO> findByStatus(Integer status){
    return service.findByStatus(status).stream().map(mapper::toDTO).collect(Collectors.toList());
  }

  private BooleanBuilder buildPredicate(JobTitleDTO jobTitleDTO) {
    BooleanBuilder builder = new BooleanBuilder();
    if (jobTitleDTO == null) {
      return builder;
    }
    if (jobTitleDTO.getStatus() != null) {
      builder.and(Q.status.eq(jobTitleDTO.getStatus()));
    }
    if (StringUtils.isNotBlank(jobTitleDTO.getTextSearch())) {
      String textSearch = jobTitleDTO.getTextSearch();
      builder.and(Q.name.containsIgnoreCase(textSearch));
    }
    return builder;
  }
}
