package com.example.demo.dto;

import com.example.demo.constant.ItemSellStatus;
import com.example.demo.entity.Categorys;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long id; // 상품 코드

    @NotBlank(message = "상품명은 필수 입력값 입니다.")
    private String iname; // 상품명

    @NotNull(message = "가격은 필수입니다.")
    @PositiveOrZero(message = "가격은 0보다 커야합니다.")
    private int price; // 가격

    @NotNull(message = "재고는 필수입니다.")
    @PositiveOrZero(message = "재고는 0보다 커야합니다.")
    private int stockNumber; // 재고수량

    @NotBlank(message = "상세설명은 필수 입니다.")
    private String itemDetail; // 상품 상세설명

    ItemSellStatus itemSellStatus; // 상품 판매 상태

    private Categorys categorys;

    private LocalDateTime regTime; // 상품 등록시간
    private LocalDateTime updateTime; // 상품 수정시간

    private String createBy;




}
