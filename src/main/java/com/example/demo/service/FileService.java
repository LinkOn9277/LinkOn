package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {

    public ImageDTO uploadFile(MultipartFile multipartFile) throws IOException; // 저장

    public ImageDTO del(String path);
}
