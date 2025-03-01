package com.example.demo.entity;

import com.example.demo.constant.Role;
import com.example.demo.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users extends BaseTimeEntity {
    // 회원의 대한 테이블 설계 후
    // Repository extends JpaRepository<E , T>

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id; // 회원 번호

    private String name; // 이름

    @Column(nullable = false, unique = true)
    private String email; // 이메일

    @Column(nullable = false)
    private String password; // 패스워드

    private String phone; // 휴대폰

    private String resident; // 주민번호

    private String addr; // 주소

    @Enumerated(EnumType.STRING)
    private Role role;

}
