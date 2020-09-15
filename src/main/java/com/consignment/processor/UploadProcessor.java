package com.consignment.processor;

import com.consignment.common.ImageUtils;
import com.consignment.dto.UploadDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 13,2020
 */
@Service
public class UploadProcessor {
    @Value("${image.upload.folder}")
    private String imageUploadFolder;
    @Value("${diskpart}")
    private String diskPart;

    public UploadDTO uploadImage(UploadDTO uploadDTO){
        MultipartFile multipartFile = uploadDTO.getMultipartFile();

        String originName = multipartFile.getOriginalFilename();

        StringBuilder nameFileRoot =
                new StringBuilder(imageUploadFolder + UUID.randomUUID() + originName);
        StringBuilder nameFile = new StringBuilder(imageUploadFolder + UUID.randomUUID() + originName);
        File file = new File(nameFile.toString());
        try {
            multipartFile.transferTo(file);
            String typeImage = StringUtils.substringAfterLast(originName, ".");
            ImageUtils.compressImage(nameFile.toString(), nameFileRoot.toString(), 0.8f, typeImage);
            String src = nameFileRoot.toString();
            src = src.replace("//", "/");
            src = src.replace(diskPart, "");
            uploadDTO.setSrc(src);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            uploadDTO.setMultipartFile(null);
            file.delete();
        }
        return uploadDTO;
    }
}
