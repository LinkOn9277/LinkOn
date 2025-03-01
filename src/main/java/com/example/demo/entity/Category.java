package com.example.demo.entity;

import com.example.demo.constant.CategoryStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id; // 대분류 카테고리

    private String cName; // 카테고리 이름

    @Enumerated(EnumType.STRING)
    private CategoryStatus categoryStatus;





}
