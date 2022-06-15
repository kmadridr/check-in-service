package com.aafcj.checkin.controller;

import com.aafcj.checkin.entity.Cabin;
import com.aafcj.checkin.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1")
public class CabinController {

    @Autowired
    private CabinRepository cabinRepository;

    @PostMapping(path="/cabins", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addCabin (@RequestBody Cabin cabin) {
        cabinRepository.save(cabin);
        return "Saved";
    }

    @GetMapping(path="/cabins", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Cabin> getCabins () {
        return cabinRepository.findAll();
    }
}
