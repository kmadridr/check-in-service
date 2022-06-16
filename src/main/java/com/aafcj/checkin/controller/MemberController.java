package com.aafcj.checkin.controller;

import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.entity.MemberEntity;
import com.aafcj.checkin.exception.MemberNotFoundException;
import com.aafcj.checkin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping(path="/api/v1")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping(path="/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(MemberEntity member) {
        service.add(member);
        return "Saved";
    }

    @GetMapping(path="/members")
    public List<MemberDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(path="/members/{id}")
    public MemberDTO getById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (MemberNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PutMapping(path="/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(MemberEntity member) {
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