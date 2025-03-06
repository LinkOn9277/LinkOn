package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.RequestPageDTO;
import com.example.demo.dto.ResponesPageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    public ImageDTO imageRegister(Long item_id, String repimgYn, MultipartFile multipartFile) throws IOException; // 저장(등록)



}
