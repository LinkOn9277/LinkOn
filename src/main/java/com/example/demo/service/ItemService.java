package com.example.demo.service;

import com.example.demo.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public ItemDTO register(ItemDTO itemDTO); // 등록

    public List<ItemDTO> itemList(); // 목록

    public ItemDTO read(Long id); // 읽기

    public ItemDTO update(ItemDTO itemDTO); // 수정

    public Long del(Long id); // 삭제


}
