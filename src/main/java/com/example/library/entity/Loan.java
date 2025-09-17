package com.example.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    @Column(nullable = false)
    private LocalDate loanDate;

    private LocalDate returnDate; // null = still borrowed
}

