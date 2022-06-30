package com.aafcj.checkin.service;

import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.exception.CabinFullException;
import com.aafcj.checkin.exception.HostGenderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private CabinService cabinService;

    public void hostMemberToCabin(int cabinId, int memberId) {
        CabinDTO cabinDTO = cabinService.getById(cabinId);
        MemberDTO memberDTO = memberService.getById(memberId);
        // Validations
        validateCapacity(cabinDTO);
        validateGender(cabinDTO, memberDTO);
        // Add new member to Cabin
        List<MemberDTO> members = cabinDTO.getMembers();
        members.add(memberDTO);
        cabinDTO.setMembers(members);

        cabinService.save(cabinDTO);
    }

    protected void validateCapacity(CabinDTO cabinDTO) {
        if (cabinDTO.getMembers().size() + 1 > cabinDTO.getCapacity()) {
            throw new CabinFullException(cabinDTO.getName());
        }
    }

    protected void validateGender(CabinDTO cabinDTO, MemberDTO memberDTO) {
        if (!cabinDTO.getGender().equals(memberDTO.getGender())) {
            throw new HostGenderException(cabinDTO.getName(), cabinDTO.getGender(), memberDTO.getName(), memberDTO.getGender());
        }
    }
}
