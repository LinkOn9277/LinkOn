package com.example.demo.controller;

import com.example.demo.dto.UsersDTO;
import com.example.demo.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@Log4j2
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/signUp")
    public String sigUp(UsersDTO usersDTO, Model model){
        log.info("회원가입 GET 진입 : " + usersDTO);
        model.addAttribute("usersDTO" , usersDTO);
        return "user/signUp";
    }

    @PostMapping("/signUp")
    public String sigUpPost(@Valid UsersDTO usersDTO, BindingResult bindingResult){
        log.info("회원가입 POST 진입 : " + usersDTO);
        if (bindingResult.hasErrors()){
            log.info("유효성 검사 실패");
            log.info(bindingResult.hasErrors());
            return "user/signUp";
        }
        try {
            usersService.sigUp(usersDTO);
        }catch (IllegalStateException e){
            return "user/signUp";
        }
        log.info("회원가입 POST 종료");
        return "redirect:/user/signUp";
    }

}
