package com.example.demo.service;

import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.RequestPageDTO;
import com.example.demo.dto.ResponesPageDTO;
import com.example.demo.entity.Image;
import com.example.demo.entity.Item;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.SearchImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ImageService imageService;




    private ModelMapper modelMapper = new ModelMapper();


    @Override // 등록
    public ItemDTO register(ItemDTO itemDTO, MultipartFile[] multipartFiles ,MultipartFile multipartFilesMain) throws IOException {

        Item item = modelMapper.map(itemDTO, Item.class);

        item = itemRepository.save(item);
        String repimgYn = null;
        imageService.imageRegister(item.getId() , "Y" , multipartFilesMain);

        if (multipartFiles != null && !(multipartFiles.length > 0)){

            for (int i = 0; i < multipartFiles.length; i++) {

                imageService.imageRegister(item.getId() , repimgYn, multipartFiles[i]);

            }
        }

        itemDTO = modelMapper.map(item, ItemDTO.class);

        return itemDTO;
    }

    @Override // 목록
    public ResponesPageDTO<ItemDTO> itemList(String email, RequestPageDTO requestPageDTO) {

        Pageable pageable = requestPageDTO.getPageable("id"); // 정렬 조건추가

        Page<Item> itemPage = itemRepository.search(requestPageDTO.getTypes(), requestPageDTO.getKeyword(), email, pageable);

        List<Item> itemList = itemPage.getContent(); // Item 변환

        List<ItemDTO> itemDTOList = itemList.stream().map(item -> modelMapper.map(item, ItemDTO.class)).collect(Collectors.toList()); // DTO 변환

        int total = (int) itemPage.getTotalElements(); // 총 게시글 수

        return new ResponesPageDTO<>(requestPageDTO, itemDTOList, total); // ResponesPageDTO 생성자 생성
    }

    @Override // 읽기
    public ItemDTO read(Long id) {

        Item item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        ItemDTO itemDTO = modelMapper.map(item , ItemDTO.class);

        return itemDTO;
    }


    @Override // 수정
    public ItemDTO update(ItemDTO itemDTO) {

        Item item = itemRepository.findById(itemDTO.getId()).orElseThrow(EntityNotFoundException::new);

        item.setPrice(itemDTO.getPrice());                    // 가격
        item.setIname(itemDTO.getIname());                      // 상품명
        item.setItemDetail(itemDTO.getItemDetail());            // 상세설명
        item.setItemSellStatus(itemDTO.getItemSellStatus());    // 판매여부
        item.setStockNumber(itemDTO.getStockNumber());          // 수량

        return itemDTO;
    }

    @Override // 삭제
    public Long del(Long id) {

        itemRepository.deleteById(id);

        return id;
    }


}
