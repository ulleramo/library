package com.example.library.service;

import com.example.library.entity.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> findAll() { return repository.findAll(); }
    public Optional<Loan> findById(Long id) { return repository.findById(id); }
    public List<Loan> findActive() { return repository.findByReturnDateIsNull(); }
    public List<Loan> findByMember(Long memberId) { return repository.findByMember_Id(memberId); }
    public List<Loan> findByBook(Long bookId) { return repository.findByBook_Id(bookId); }
    public Loan save(Loan loan) { return repository.save(loan); }
    public void delete(Long id) { repository.deleteById(id); }
}
