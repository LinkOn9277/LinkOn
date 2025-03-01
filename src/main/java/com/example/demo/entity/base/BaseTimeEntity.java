package com.example.demo.entity.base;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime; // 등록날짜

    @LastModifiedDate
    private LocalDateTime updateTime; // 수정날짜


}
