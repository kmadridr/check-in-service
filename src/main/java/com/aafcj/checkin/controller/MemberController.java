package com.aafcj.checkin.controller;

import com.aafcj.checkin.entity.Member;
import com.aafcj.checkin.exception.MemberNotFoundException;
import com.aafcj.checkin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(path="/api/v1")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping(path="/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(Member member) {
        service.add(member);
        return "Saved";
    }

    @GetMapping(path="/members")
    public Iterable<Member> getAll() {
        return service.getAll();
    }

    @GetMapping(path="/members/{id}")
    public Member getById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (MemberNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PutMapping(path="/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(Member member) {
        try {
            service.update(member);
            return "Updated";
        } catch (MemberNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @DeleteMapping(path="/members/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@PathVariable int id) {
        service.deleteById(id);
        return "Deleted";
    }

}