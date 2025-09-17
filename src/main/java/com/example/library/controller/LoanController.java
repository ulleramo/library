package com.example.library.controller;

import com.example.library.dto.LoanDTO;
import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Member;
import com.example.library.service.BookService;
import com.example.library.service.LoanService;
import com.example.library.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final BookService bookService;
    private final MemberService memberService;

    public LoanController(LoanService loanService, BookService bookService, MemberService memberService) {
        this.loanService = loanService;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    // ---- Mapping helpers ----
    private LoanDTO toDto(Loan loan) {
        LoanDTO dto = new LoanDTO();
        dto.setId(loan.getId());
        dto.setBookId(loan.getBook().getId());
        dto.setMemberId(loan.getMember().getId());
        dto.setLoanDate(loan.getLoanDate());
        dto.setReturnDate(loan.getReturnDate());
        return dto;
    }

    private Loan toEntity(LoanDTO dto) {
        Book book = bookService.findById(dto.getBookId()).orElseThrow();
        Member member = memberService.findById(dto.getMemberId()).orElseThrow();
        return Loan.builder()
                .id(dto.getId())
                .book(book)
                .member(member)
                .loanDate(dto.getLoanDate())
                .returnDate(dto.getReturnDate())
                .build();
    }
    // -------------------------

    @GetMapping
    public List<LoanDTO> all() {
        return loanService.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/active")
    public List<LoanDTO> active() {
        return loanService.findActive().stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/by-member/{memberId}")
    public List<LoanDTO> byMember(@PathVariable Long memberId) {
        return loanService.findByMember(memberId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/by-book/{bookId}")
    public List<LoanDTO> byBook(@PathVariable Long bookId) {
        return loanService.findByBook(bookId).stream().map(this::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LoanDTO one(@PathVariable Long id) {
        return loanService.findById(id).map(this::toDto).orElseThrow();
    }

    @PostMapping
    public LoanDTO create(@Valid @RequestBody LoanDTO dto) {
        Loan saved = loanService.save(toEntity(dto));
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public LoanDTO update(@PathVariable Long id, @Valid @RequestBody LoanDTO dto) {
        dto.setId(id);
        Loan saved = loanService.save(toEntity(dto));
        return toDto(saved);
    }

    // Convenience endpoint: mark as returned (sets returnDate = today)
    @PostMapping("/{id}/return")
    public LoanDTO markReturned(@PathVariable Long id) {
        Loan loan = loanService.findById(id).orElseThrow();
        loan.setReturnDate(java.time.LocalDate.now());
        return toDto(loanService.save(loan));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loanService.delete(id);
    }
}
