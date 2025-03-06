package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.RequestPageDTO;
import com.example.demo.dto.ResponesPageDTO;
import com.example.demo.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ItemService {

    public ItemDTO register(ItemDTO itemDTO, MultipartFile[] multipartFiles ,MultipartFile multipartFile) throws IOException; // 등록

    public ResponesPageDTO<ItemDTO> itemList(String email, RequestPageDTO requestPageDTO); // 목록

    public ItemDTO read(Long id); // 읽기

    public ItemDTO update(ItemDTO itemDTO); // 수정

    public Long del(Long id); // 삭제


}
