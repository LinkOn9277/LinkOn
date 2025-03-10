package com.example.demo.entity;

import com.example.demo.constant.ItemSellStatus;
import com.example.demo.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id; // 상품 코드

    private String iname; // 상품명

    private int price; // 가격

    private int stockNumber; // 재고수량

    private String itemDetail; // 상품 상세설명

    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorys_id")
    private Categorys categorys;

    @OneToMany(mappedBy = "item" , fetch = FetchType.LAZY)
    private List<Image> imageList;


//    private LocalDateTime regTime; // 상품 등록시간
//    private LocalDateTime updateTime; // 상품 수정시간




}
