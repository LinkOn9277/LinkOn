package com.example.demo.service;

import com.example.demo.dto.UsersDTO;
import com.example.demo.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    public String sigUp(UsersDTO usersDTO); // 회원가입

    public List<UsersDTO> findAll(); // 목록

    public UsersDTO read(Long id); // 조회




}
