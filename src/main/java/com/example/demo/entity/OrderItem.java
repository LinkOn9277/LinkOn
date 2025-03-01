package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderitem_id")
    private Long id;

    private int oPrice; // 주문 가격

    private int count; // 주문 수량

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 1:N
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 1:N
    @JoinColumn(name = "order_id")
    private Orders orders;


}
