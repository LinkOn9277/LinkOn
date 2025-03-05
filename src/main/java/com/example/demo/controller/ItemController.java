package com.example.demo.controller;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
@Log4j2
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/register") // 등록 GET
    public String register(ItemDTO itemDTO) {
        log.info("상품 등록 GET 진입");
        return "item/register";
    }

    @PostMapping("/register") // 등록 POST
    public String registerPost(@Valid ItemDTO itemDTO, BindingResult bindingResult,MultipartFile multipartFilesMain, MultipartFile[] multipartFiles, RedirectAttributes redirectAttributes) {
        log.info("상품 등록 POST 진입");

        if (bindingResult.hasErrors()) { return "item/register"; }

        try {
            itemDTO = itemService.register(itemDTO , multipartFiles, multipartFilesMain);
            log.info("저장된 데이터 : " + itemDTO);
        }catch (IOException e){
            //사진에 관한 예외처리 메시지 담기
            // 담은거 html에서 처리 해주기
            return "item/register";
        }


        log.info("상품 등록 POST 종료");
        return "item/register";
    }

    @GetMapping("/list") // 목록 GET
    public String list(Model model){
        log.info("상품 리스트 진입");

        List<ItemDTO> itemDTOList = itemService.itemList();

        return "item/list";
    }

    @GetMapping("/read") // 읽기 GET
    public String read(Long id){
        log.info("상품 정보 GET 진입");

        if (id == null){ return "redirect:/item/list"; }

        ItemDTO itemDTO = itemService.read(id);

        return "redirect:/item/list";
    }

    @GetMapping("/modify") // 수정 GET
    public String modify(Long id){
        log.info("상품 수정 GET 진입");

        if (id == null){ return "redirect:/item/list"; }

        ItemDTO itemDTO = itemService.read(id);

        return "item/modify";
    }

    @PostMapping("/modify") // 수정 POST
    public String modifyPost(ItemDTO itemDTO){
        log.info("상품 수정 Post 진입");

        itemDTO = itemService.update(itemDTO);

        return null;
    }

    @PostMapping("/del")
    public String delPost(ItemDTO itemDTO){
        log.info("상품 삭제 Post 진입");

        itemService.del(itemDTO.getId());

        return "redirect:/item/list";
    }



}
