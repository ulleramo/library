package com.example.library.repository;

import com.example.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByReturnDateIsNull();         // active loans
    List<Loan> findByMember_Id(Long memberId);   // loans by member
    List<Loan> findByBook_Id(Long bookId);       // loans by book
}
