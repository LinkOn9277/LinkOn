package com.example.demo.controller;

import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.RequestPageDTO;
import com.example.demo.dto.ResponesPageDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
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
import java.security.Principal;
import java.util.Arrays;
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
        log.info("상품 등록 GET 진입");
        log.info("상품 등록 GET 진입");
        log.info("상품 등록 GET 진입");
        return "item/register";
    }

    @PostMapping("/register") // 등록 POST
    public String registerPost(@Valid ItemDTO itemDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                   MultipartFile multipartFilesMain, MultipartFile[] multipartFiles, Model model) {

        log.info("상품 등록 POST 진입");
        log.info("상품 등록 POST 진입");
        log.info("상품 등록 POST 진입");
        log.info("상품 등록 POST 진입");

        // 들어온 파일 로그
        if (multipartFilesMain != null && !multipartFilesMain.isEmpty()){
            log.info(multipartFilesMain);
            log.info(multipartFilesMain.getOriginalFilename());
            log.info(multipartFilesMain.getSize());
        }else {
            log.info("사진 없음");
            log.info("사진 없음");
            log.info("사진 없음");
            log.info("사진 없음");
        }

        if (multipartFiles != null){
            for (MultipartFile multipartFile : multipartFiles){
                log.info(multipartFile);
                log.info(multipartFile.getOriginalFilename());
                log.info(multipartFile.getSize());
            }
        }

        if (bindingResult.hasErrors()) { return "item/register"; }

        if (multipartFilesMain.isEmpty()){
            model.addAttribute("msg", "대표이미지는 꼭 이어야 합니다.");
            return "item/register";
        }

        try {
            itemDTO = itemService.register(itemDTO , multipartFiles, multipartFilesMain);
            log.info("저장된 데이터 : " + itemDTO);
        }catch (IOException e){
            model.addAttribute("msg", "이미지 저장이 실패했습니다.");
            return "item/register";
        }

        redirectAttributes.addFlashAttribute("iname", itemDTO.getIname());

        log.info("상품 등록 POST 종료");
        log.info("상품 등록 POST 종료");
        log.info("상품 등록 POST 종료");
        log.info("상품 등록 POST 종료");
        return "item/register";
    }

    @GetMapping("/list") // 목록 GET
    public String list(RequestPageDTO requestPageDTO, Model model, Principal principal){
        log.info("상품 리스트 진입");
        log.info("상품 리스트 진입");
        log.info("상품 리스트 진입");
        log.info("상품 리스트 진입");

        ResponesPageDTO<ItemDTO> responesPageDTO = itemService.itemList(principal.getName(), requestPageDTO, 1);

        model.addAttribute("responesPageDTO", responesPageDTO);

        log.info("상품 리스트 종료");
        log.info("상품 리스트 종료");
        log.info("상품 리스트 종료");
        log.info("상품 리스트 종료");
        return "item/list";
    }

    @GetMapping("/read") // 읽기 GET
    public String read(Long id, Model model, Principal principal, RedirectAttributes redirectAttributes){
        log.info("상품 정보 GET 진입");
        log.info("상품 정보 GET 진입");
        log.info("상품 정보 GET 진입");
        log.info("상품 정보로 들어온 ID : " + id);

        if (id == null){
            return "redirect:/item/list";
        }

        try {
            ItemDTO itemDTO = itemService.read(id);

            if(!itemDTO.getCreateBy().equals(principal.getName())){
                log.info("여기실행");
                return "redirect:/item/list";
            }

            model.addAttribute("itemDTO", itemDTO);

            return "item/read";

        }catch (EntityNotFoundException e){

            redirectAttributes.addFlashAttribute("msg", "존재하지 않는 상품입니다.");

            log.info("상품 정보 GET 종료");
            log.info("상품 정보 GET 종료");
            log.info("상품 정보 GET 종료");
            log.info("상품 정보 GET 종료");

            return "redirect:/item/list";
        }


    }

    @GetMapping("/update") // 수정 GET
    public String update(Long id, Model model, Principal principal, RedirectAttributes redirectAttributes){
        log.info("상품 수정 GET 진입");
        log.info("상품 수정 GET 진입");
        log.info("상품 수정 GET 진입");
        log.info("상품 수정 GET 진입");

        if (id == null){ return "redirect:/item/list"; }

        try {

          ItemDTO itemDTO = itemService.read(id);
          log.info("상품정보" + itemDTO);

          if (!itemDTO.getCreateBy().equals(principal.getName())){
              log.info("수정 실패 리스트 페이지로 이동");
              return "redirect:/item/list";
          }

          model.addAttribute("itemDTO", itemDTO);
          return "item/updete";

        }catch (EntityNotFoundException e){
            redirectAttributes.addFlashAttribute("msg", "존재하지 않는 상품입니다.");
        }

        log.info("상품 수정 GET 종료");
        log.info("상품 수정 GET 종료");
        log.info("상품 수정 GET 종료");
        log.info("상품 수정 GET 종료");

        return "redirect:/item/list";
    }

    @PostMapping("/update") // 수정 POST
    public String updatePost(@Valid ItemDTO itemDTO, MultipartFile[] multipartFiles, MultipartFile multipartFileMain, Long[] delino){
        log.info("상품 수정 Post 진입");
        log.info("상품 수정 Post 진입");
        log.info("상품 수정 Post 진입");
        log.info("상품 수정 Post 진입");

        if (!multipartFileMain.isEmpty()){
            log.info(multipartFileMain.getOriginalFilename());
        }else {
            log.info("등록되는 메인 이미지가 없습니다.");
        }

        if (multipartFiles != null){
            for (MultipartFile file : multipartFiles){
                if (!file.isEmpty()){
                    log.info("들어온 상세 이미지");
                    log.info(file.getOriginalFilename());
                }
            }
        }else {
            log.info("등록되는 상세 이미지가 없습니다.");
        }

        if (delino != null && delino.length != 0){
            log.info(Arrays.toString(delino));
        }
        log.info(itemDTO);

        try {
          itemService.update(itemDTO, multipartFiles, multipartFileMain, delino);
        }catch (IOException e){
          log.info("이미지 수정 실패");
          return "redirect:/item/read?id=" + itemDTO.getId();
        }


        log.info("상품 수정 Post 종료");
        log.info("상품 수정 Post 종료");
        log.info("상품 수정 Post 종료");
        log.info("상품 수정 Post 종료");

        return "redirect:/item/read?id=";
    }

    @PostMapping("/del")
    public String delPost(ItemDTO itemDTO){
        log.info("상품 삭제 Post 진입");
        log.info("상품 삭제 Post 진입");
        log.info("상품 삭제 Post 진입");
        log.info("상품 삭제 Post 진입");

        itemService.del(itemDTO.getId());

        log.info("상품 삭제 Post 종료");
        log.info("상품 삭제 Post 종료");
        log.info("상품 삭제 Post 종료");
        log.info("상품 삭제 Post 종료");

        return "redirect:/item/list";
    }



}
