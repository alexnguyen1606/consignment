package com.consignment.mapper;

import com.consignment.dto.LoggingDTO;
import com.consignment.entity.Logging;
import com.consignment.mapper.resolver.LoggingResolver;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 *     <p>September 12,2020
 */
@Component
@Mapper(uses = {LoggingResolver.class})
public interface LoggingMapper extends CommonMapper<Logging, LoggingDTO> {
}
