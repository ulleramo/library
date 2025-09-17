package com.example.library.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanDTO {
    private Long id;
    private Long bookId;
    private Long memberId;
    private LocalDate loanDate;
    private LocalDate returnDate; // null when active
}
