package com.aafcj.checkin.helper;


import com.aafcj.checkin.Gender;
import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.dto.MemberDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class CabinFinderHelperTest {

    CabinFinderHelper cabinFinderHelper;


    @Test
    public void testFindForAMember() {

        cabinFinderHelper = new CabinFinderHelper();

        List<CabinDTO> cabins = Arrays.asList(
                CabinDTO.builder().gender(Gender.MALE).name("A1").capacity(4).build(),
                CabinDTO.builder().gender(Gender.FEMALE).name("A2").capacity(4).build(),
                CabinDTO.builder().gender(Gender.MALE).name("A3").capacity(4).build()
        );

        MemberDTO memberDTO = MemberDTO.builder().gender(Gender.MALE).build();

        List<CabinDTO> actualResult = cabinFinderHelper.findForAMember(memberDTO, cabins);

        List<CabinDTO> expectedResult = Arrays.asList(
                CabinDTO.builder().gender(Gender.MALE).name("A1").capacity(4).build(),
                CabinDTO.builder().gender(Gender.MALE).name("A3").capacity(4).build()
        );

        Assertions.assertEquals(actualResult, expectedResult);
    }

}