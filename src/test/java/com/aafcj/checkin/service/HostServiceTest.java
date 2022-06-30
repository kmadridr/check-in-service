package com.aafcj.checkin.service;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.exception.CabinFullException;
import com.aafcj.checkin.exception.HostGenderException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HostServiceTest {

    @Test
    public void testValidateCapacityException() {
        CabinDTO cabinDTO = CabinDTO.builder().name("TestCabin").capacity(0)
                .members(Arrays.asList(MemberDTO.builder().name("Kevin").build())).build();
        HostService hostService = new HostService();

        Exception exception = assertThrows(CabinFullException.class, () -> hostService.validateCapacity(cabinDTO));
        assertEquals("Cabin TestCabin have reached it's capacity", exception.getMessage());
    }


    @Test
    public void testValidateGenderException() {
        CabinDTO cabinDTO = CabinDTO.builder().name("TestCabin").capacity(2).gender(Gender.FEMALE).build();
        MemberDTO memberDTO = MemberDTO.builder().name("Kevin").gender(Gender.MALE).build();
        HostService hostService = new HostService();

        Exception exception = assertThrows(HostGenderException.class, () -> hostService.validateGender(cabinDTO, memberDTO));
        assertEquals("The cabin TestCabin is for female gender. Member Kevin is a male", exception.getMessage());
    }

}