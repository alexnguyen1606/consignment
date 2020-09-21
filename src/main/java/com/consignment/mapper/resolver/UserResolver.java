package com.consignment.mapper.resolver;

import com.consignment.dto.JobTitleDTO;
import com.consignment.dto.UsersDTO;
import com.consignment.entity.Users;
import com.consignment.mapper.JobTitleMapper;
import com.consignment.service.JobTitleService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 21,2020
 */
@Component
@AllArgsConstructor
public class UserResolver {
  private JobTitleService jobTitleService;
  private JobTitleMapper jobTitleMapper;

  @ObjectFactory
  private UsersDTO resolve(Users users, @TargetType Class<UsersDTO> type) {
    UsersDTO usersDTO = new UsersDTO();
    JobTitleDTO jobTitle =
        jobTitleMapper.toDTO(jobTitleService.findById(users.getJobTitleId()).get());
    usersDTO.setJobTitle(jobTitle);
    return usersDTO;
  }
}
