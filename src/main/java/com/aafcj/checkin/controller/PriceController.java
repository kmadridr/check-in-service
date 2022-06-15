package com.aafcj.checkin.controller;

import com.aafcj.checkin.entity.Price;
import com.aafcj.checkin.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path="/api/v1")
public class PriceController {

    @Autowired
    PriceRepository priceRepository;


    @GetMapping(path="/prices/{role}/{place}/{time}")
    public Price getPriceById(@PathVariable("role") String role, @PathVariable("place") String place,
                                             @PathVariable("time") String time) {
        //TODO: Validate role exists

        Stream<Price> priceStream = StreamSupport.stream(priceRepository.findAll().spliterator(), false);

        return priceStream.filter(price -> price.getRole().equals(role))
                .filter(price -> price.getPlace().equals(place))
                .filter(price -> price.getTime().equals(time))
                .findFirst().get();
    }

}
