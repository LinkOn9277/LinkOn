package com.example.demo.controller;

import com.example.demo.dto.ItemDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
@Log4j2
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/register")
    public String register(ItemDTO itemDTO) {

        return "item/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid ItemDTO itemDTO, BindingResult bindingResult) {
        log.info("상품 등록 POST 페이지 진입");

        if (bindingResult.hasErrors()) {
            return "item/register";
        }


        return "item/register";
    }

}
