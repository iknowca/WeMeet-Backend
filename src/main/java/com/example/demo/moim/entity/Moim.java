package com.example.demo.moim.entity;

import com.example.demo.board.entity.MoimBoard;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Moim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "moim")
    private State state;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "moim")
    private MoimDestination destination;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "moim")
    private MoimPaymentInfo moimPaymentInfo;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "moim")
    private MoimParticipantsInfo participantsInfo;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MoimContents contents;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "moim")
    private List<MoimBoard> boards;
}
