package com.example.library.service;

import com.example.library.entity.Member;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    public Member save(Member member) {
        return repository.save(member);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
