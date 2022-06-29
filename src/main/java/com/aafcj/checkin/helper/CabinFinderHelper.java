package com.aafcj.checkin.helper;


import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CabinFinderHelper {

    @Autowired
    CabinService cabinService;

    /**
     * Returns a list filtering the cabines list based on Cabin Gender. Comparing
     * with member gender
     * @param memberDTO
     * @param cabines
     * @return
     */
    protected List<CabinDTO> findForAMember(MemberDTO memberDTO, List<CabinDTO> cabines) {
        return cabines.stream()
                .filter((cabin) -> cabin.getGender().equals(memberDTO.getGender()))
                .collect(Collectors.toList());
    }

    public List<CabinDTO> find(MemberDTO member) {
        return findForAMember(member, cabinService.getAll());
    }
}
