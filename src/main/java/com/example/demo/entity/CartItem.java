package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cartitem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartitem_id")
    private Long id;

    private int count; // 수량

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 1:N
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 1:N
    @JoinColumn(name = "item_id")
    private Item item;

}
