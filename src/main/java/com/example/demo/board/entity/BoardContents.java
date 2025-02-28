package com.example.demo.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BoardContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(length = 3000)
    private String content;
    @OneToOne(fetch = FetchType.LAZY)
    @Setter
    private Board board;
}
