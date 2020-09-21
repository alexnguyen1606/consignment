package com.consignment.mapper;

import com.consignment.dto.JobTitleDTO;
import com.consignment.entity.JobTitle;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
@Mapper
@Component
public interface JobTitleMapper extends CommonMapper<JobTitle, JobTitleDTO> {
}
