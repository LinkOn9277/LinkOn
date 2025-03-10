package com.example.demo.controller;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.RequestPageDTO;
import com.example.demo.dto.ResponesPageDTO;
import com.example.demo.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {

    private final ItemService itemService;

    @GetMapping("/")
    public String mainPage(){
        return "/main";
    }

    @GetMapping("/item/readmain")
    public String read(RequestPageDTO requestPageDTO, Long id, Model model, RedirectAttributes redirectAttributes){
        log.info("메인화면 상품정보 페이지 진입");
        log.info("메인화면 상품정보 페이지 진입");
        log.info("메인화면 상품정보 페이지 진입");
        log.info("메인화면 상품정보 페이지 진입");


        if (id == null){
            ResponesPageDTO<ItemDTO> responesPageDTO = itemService.itemList(null, requestPageDTO, 2);
            model.addAttribute("responesPageDTO", responesPageDTO);
            return "/main";
        }

        try {

            ItemDTO itemDTO = itemService.read(id);
            log.info("상품정보" + itemDTO);
            model.addAttribute("itemDTO", itemDTO);

        }catch (EntityNotFoundException e){

            redirectAttributes.addFlashAttribute("msg", "존재하지 않는 상품입니다.");
            return "redirect:/";
        }
        return null;

    }


}
