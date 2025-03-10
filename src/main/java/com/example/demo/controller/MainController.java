package com.example.demo.controller;

import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MainController {

    private final ItemService itemService;

    @GetMapping("/")
    public String mainPage(){
        return "/main";
    }


}
