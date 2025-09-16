package com.example.library.controller;

import com.example.library.entity.Member;
import com.example.library.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public List<Member> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Member one(@PathVariable Long id) {
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public Member create(@Valid @RequestBody Member member) {
        return service.save(member);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @Valid @RequestBody Member member) {
        member.setId(id);
        return service.save(member);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
