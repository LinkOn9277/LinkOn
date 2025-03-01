package com.example.demo.entity.base;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

public class BaseEntity extends BaseTimeEntity{

    @CreatedBy
    @Column(updatable = false)
    private String createBy; // 작성자

    @LastModifiedBy
    private String modifiedBy; // 수정자

}
