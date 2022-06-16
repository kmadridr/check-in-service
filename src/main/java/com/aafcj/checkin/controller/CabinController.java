package com.aafcj.checkin.controller;

import com.aafcj.checkin.entity.Cabin;
import com.aafcj.checkin.exception.CabinNotFoundException;
import com.aafcj.checkin.repository.CabinRepository;
import com.aafcj.checkin.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class CabinController {

    @Autowired
    private CabinService service;

    @PostMapping(path="/cabins", consumes = MediaType.APPLICATION_JSON_VALUE)


    public String addCabin (Cabin cabin) {
        service.add(cabin);
        return "Saved";
    }

    @GetMapping(path="/cabins", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Cabin> getAll() {
        return service.getAll();
    }

    @GetMapping(path="/cabins/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cabin getByName(@PathVariable String name) {
        try {
            return service.getByName(name);
        } catch (CabinNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
