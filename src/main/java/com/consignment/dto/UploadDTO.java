package com.consignment.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadDTO {
    private MultipartFile multipartFile;

    private String src;

    private String size;

    private String name;

    private Long totalFileSlide;

    private String idFileScorm;

    private Long totalFileQuitz;

    private Long duration;
}
