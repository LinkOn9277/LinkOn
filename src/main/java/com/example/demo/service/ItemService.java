package com.example.demo.service;

import com.example.demo.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public ItemDTO register(ItemDTO itemDTO); // 등록

    public List<ItemDTO> itemList(); // 목록

    public ItemDTO read(Long id);

    public ItemDTO update(ItemDTO itemDTO);

    public Long del(Long id);


}
