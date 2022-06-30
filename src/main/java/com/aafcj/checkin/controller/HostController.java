package com.aafcj.checkin.controller;

import com.aafcj.checkin.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path="/api/v1")
public class HostController {

    @Autowired
    private HostService hostService;


    @PostMapping(path="/host/{cabinId}/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String hostMemberToCabin(@PathVariable Integer cabinId, @PathVariable Integer memberId) {
        try {
            hostService.hostMemberToCabin(cabinId, memberId);
        } catch (Exception ex) {
            // I dont see my message in the HTTP REsponse!!
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
        return "200";
    }
}
