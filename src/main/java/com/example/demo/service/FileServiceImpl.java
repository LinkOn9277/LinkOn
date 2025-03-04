package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ItemDTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
@Service
@Log4j2
public class FileServiceImpl implements FileService{

    @Value("${imgLocation}")
    String imageLocation;


    @Override
    public ImageDTO uploadFile(MultipartFile multipartFile) throws IOException {

        log.info("물리적으로 저장된 사진 DTO 반환 : " + multipartFile.getOriginalFilename());

        String oriImgName = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("/") + 1 );

        log.info("확장자를 포함한 실제 이미지명" + oriImgName);

        UUID uuid = UUID.randomUUID();

        String imgName = uuid.toString() + "_" + oriImgName;
        String fileuploadpath = imageLocation + imgName;

        log.info("물리적인 파일 이름 : " + fileuploadpath);

        // 예외로 시그니처 추가로 컨트롤러에서 예외처리 하면 됨
        FileOutputStream fos = new FileOutputStream(fileuploadpath);

        fos.write(multipartFile.getBytes());
        fos.close();

        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImgName(imgName);
        imageDTO.setIurl(imageLocation);
        imageDTO.setOrimgName(oriImgName);

        return imageDTO;
    }

    @Override
    public ImageDTO del(String path) {

        ImageDTO imageDTO = new ImageDTO();

        File file = new File(path);
        if (file.exists()){
            file.delete();
        }

        return imageDTO;
    }
}
