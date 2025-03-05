package com.example.demo.dto;

import com.example.demo.constant.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {


    private String name; // 이름


    private String email; // 이메일


    private String password; // 패스워드


    private String phone; // 휴대폰


    private String resident; // 주민번호


    private String addr; // 주소


    private Role role;


}
