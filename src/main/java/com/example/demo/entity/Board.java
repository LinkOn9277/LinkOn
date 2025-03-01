package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_bno")
    private Long bno;

    private String title;

    private String content;



    @ManyToOne(fetch = FetchType.LAZY) // 다대일 1:N
    @JoinColumn(name = "user_id")
    private Users users;

}
