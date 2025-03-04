package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    public ImageDTO imageRegister(ImageDTO imageDTO, String repimgYn, MultipartFile multipartFile) throws IOException; // 저장(등록)

}
