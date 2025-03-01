package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id; // 상품 코드

    private String iname; // 상품명

    private int price; // 상품 가격

    private int stockNumber; // 상품 수량

    private String itemDetail; // 상품 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorys_id")
    private Categorys categorys;




}
