package com.example.demo.dto;

import com.example.demo.constant.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

    private Long num;

    @NotBlank(message = "이름은 필수 입력입니다.")
    @Length(min = 2, max = 20, message = "이름은 2자이상, 20자 이하로 입력해주세요.")
    private String name; // 이름

    @NotBlank
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email; // 이메일

    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password; // 패스워드

    @NotBlank(message = "휴대폰번호는 필수 입력입니다.")
    private String phone; // 휴대폰

    @NotBlank(message = "주민번호는 필수로 입력해야합니다.")
    private String resident; // 주민번호

    @NotBlank(message = "주소는 필수로 입력해야합니다.")
    private String addr; // 주소


    private String role;


}
