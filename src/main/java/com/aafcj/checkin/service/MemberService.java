package com.aafcj.checkin.service;

import com.aafcj.checkin.entity.Member;
import com.aafcj.checkin.exception.MemberNotFoundException;
import com.aafcj.checkin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member getById(Integer id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
    }

    public void deleteById(Integer id) {
        memberRepository.deleteById(id);
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public void add(Member member) {
        memberRepository.save(member);
    }

    public void update(Member member) {
        Member tmp = memberRepository.findById(member.getId())
                .orElseThrow(() -> new MemberNotFoundException(member.getId()));
        tmp.setName(member.getName());
        tmp.setLastName(member.getLastName());
        tmp.setCabin(member.getCabin());
        tmp.setGender(member.getGender());
        tmp.setPaid(member.getPaid());
        tmp.setRole(member.getRole());
        memberRepository.save(tmp);
    }
}
