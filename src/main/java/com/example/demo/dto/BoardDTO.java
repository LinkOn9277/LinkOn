package com.example.demo.dto;

import com.example.demo.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardDTO {

    private Long bno;
    private String title;
    private String content;

    private UsersDTO usersDTO;

}
