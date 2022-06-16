package com.aafcj.checkin.controller;

import com.aafcj.checkin.dto.PriceDTO;
import com.aafcj.checkin.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class PriceController {

    @Autowired
    PriceService service;

    @GetMapping(path = "/prices")
    public List<PriceDTO> getAll() {
        return service.findAll();
    }
    @GetMapping(path="/prices/{role}/{place}/{time}")
    public PriceDTO getById(@PathVariable String role, @PathVariable String place,
                                 @PathVariable String time) {
        //TODO: Validate role exists

        return service.findAll().stream()
                .filter(price -> price.getRole().equals(role))
                .filter(price -> price.getPlace().equals(place))
                .filter(price -> price.getTime().equals(time))
                .findFirst().get();
    }

}