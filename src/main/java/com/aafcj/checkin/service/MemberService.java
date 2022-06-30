package com.aafcj.checkin.service;

import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.exception.MemberNotFoundException;
import com.aafcj.checkin.mapper.MapStructMapper;
import com.aafcj.checkin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public MemberDTO getById(Integer id) {
        return mapStructMapper
                .memberEntityToMemberDTO(
                        memberRepository.findById(id)
                                .orElseThrow(() -> new MemberNotFoundException(id)));

    }

    public void deleteById(Integer id) {
        memberRepository.deleteById(id);
    }

    public List<MemberDTO> getAll() {
        return mapStructMapper.memberEntitiesToMemberDTOs(memberRepository.findAll());
    }

    public void save(MemberDTO member) {
        memberRepository.save(mapStructMapper.memberDTOToMemberEntity(member));
    }

    public void saveAll(List<MemberDTO> memberDTOs) {
        memberRepository.saveAll(mapStructMapper.memberDTOsToMemberEntities(memberDTOs));
    }

//    public MemberDTO update(MemberDTO member) {
//        MemberEntity tmp = memberRepository.findById(member.getId())
//                .orElseThrow(() -> new MemberNotFoundException(member.getId()));
//
////        MemberEntity memberEntity = mapStructMapper.memberDTOToMemberEntity(member);
//
////        String cabin = cabinFinderHelper.find(member);
//
//        tmp.setName(member.getName());
//        tmp.setLastName(member.getLastName());
////        tmp.setCabin(member.getCabin());
//        tmp.setGender(member.getGender());
//        tmp.setPaid(member.getPaid());
//        tmp.setRole(member.getRole());
//        memberRepository.save(tmp);
//
//        return mapStructMapper.memberEntityToMemberDTO(tmp);
//
//    }
}
