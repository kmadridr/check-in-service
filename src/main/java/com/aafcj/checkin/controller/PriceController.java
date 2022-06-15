package com.aafcj.checkin.controller;

import com.aafcj.checkin.Role;
import com.aafcj.checkin.entity.Member;
import com.aafcj.checkin.entity.Price;
import com.aafcj.checkin.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(path="/api/v1")
public class PriceController {

    @Autowired
    PriceRepository priceRepository;


    @GetMapping(path="/prices/{role}/{place}/{time}")
    public @ResponseBody Price getPriceById(@PathVariable("role") String role, @PathVariable("place") String place,
                                             @PathVariable("time") String time) {
        //TODO: Validate role exists

        Stream<Price> priceStream = StreamSupport.stream(priceRepository.findAll().spliterator(), false);

        return priceStream.filter(price -> price.getRole().equals(role))
                .filter(price -> price.getPlace().equals(place))
                .filter(price -> price.getTime().equals(time))
                .findFirst().get();
    }

}
