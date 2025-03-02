package com.example.demo.service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override // 상품등록
    public ItemDTO register(ItemDTO itemDTO) {

        Item item = modelMapper.map(itemDTO, Item.class);

        item = itemRepository.save(item);

        itemDTO = modelMapper.map(item, ItemDTO.class);

        return itemDTO;
    }
}
