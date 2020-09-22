package com.consignment.dto;

import lombok.Data;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 21,2020
 */
@Data
public class JobTitleDTO extends BaseDTO {
    private String name;
    private Integer status;
    private String jobTitleCode;
    private String description;
}
