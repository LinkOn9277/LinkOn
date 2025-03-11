package com.example.demo.controller;

import com.example.demo.dto.UsersDTO;
import com.example.demo.service.UsersService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
        log.info("회원가입 POST 진입 : " + usersDTO.getEmail().replace(",","@"));

        if (bindingResult.hasErrors()){
            log.info("유효성 검사 실패");
            log.info(bindingResult.getAllErrors());
            return "user/signUp";
        }
        try {
            usersService.sigUp(usersDTO);
        }catch (IllegalStateException e){
            return "user/signUp";
        }
        log.info("회원가입 POST 종료");
        return "redirect:/user/login";
    }

    @GetMapping("login")
    public String login(){
        log.info("로그인 페이지 진입");
        return "user/login";
    }


    @GetMapping("/list")
    public String list(Model model){
        log.info("회원 목록 진입");
        log.info("회원 목록 진입");
        log.info("회원 목록 진입");
        log.info("회원 목록 진입");

        List<UsersDTO> usersDTOList = usersService.findAll();
        model.addAttribute("usersDTOList" , usersDTOList);

        log.info("회원 목록 종료");
        log.info("회원 목록 종료");
        log.info("회원 목록 종료");
        log.info("회원 목록 종료  ");

        return "user/list";
    }

    @GetMapping("read")
    public String readGET(Long id, Model model){
        log.info("회원 목록조회 진입");
        log.info("회원 목록조회 진입");
        log.info("회원 목록조회 진입");
        log.info("회원 목록조회 진입");
        log.info("들어온값 : " + id);



        UsersDTO usersDTO = usersService.read(id);
        if (id != null){
            return "user/read";
        }
        model.addAttribute("usersDTO", usersDTO);

        log.info("회원 목록조회 종료");
        log.info("회원 목록조회 종료");
        log.info("회원 목록조회 종료");
        log.info("회원 목록조회 종료");

        return "user/read";
    }

}
