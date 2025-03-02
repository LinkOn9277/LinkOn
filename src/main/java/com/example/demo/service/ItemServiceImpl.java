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
        // modelMapper : DTO 와 Entity 간 변환을 도와주는 라이브러리
        // itemDTO 객체를 Item 클래스의 객체로 변환
        // 변환 Item 객체를 item 변수에 저장
        Item item = modelMapper.map(itemDTO, Item.class);
        // itemRepository 의 item Entity → DB에 저장
        item = itemRepository.save(item);
        // 저장된 item 객체를 다시 ItemDTO 객체로 변환
        itemDTO = modelMapper.map(item, ItemDTO.class);
        // 변환 된 ItemDTO 객체를 반환
        return itemDTO;
    }
}
