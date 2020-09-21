package com.consignment.mapper;

import com.consignment.dto.CabinetDTO;
import com.consignment.entity.Cabinet;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
@Mapper
@Component
public interface CabinetMapper extends CommonMapper<Cabinet, CabinetDTO> {
}
