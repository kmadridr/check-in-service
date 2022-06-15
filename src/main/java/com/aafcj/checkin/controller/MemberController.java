package com.aafcj.checkin.controller;

import com.aafcj.checkin.entity.Member;
import com.aafcj.checkin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/api/v1")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping(path="/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addMember (@RequestBody Member member) {
        memberRepository.save(member);
        return "Saved";
    }

    @GetMapping(path="/members")
    public @ResponseBody Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping(path="/members/{id}")
    public @ResponseBody Member getMemberById(@PathVariable("id") int id) {
        return memberRepository.findById(id).get();
    }

    @PutMapping(path="/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String editUser (@RequestBody Member member) {
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        if (optionalMember.isPresent()) {
            Member newMember = optionalMember.get();
            newMember.setName(member.getName());
            newMember.setLastName(member.getLastName());
            newMember.setPaid(member.getPaid());
            newMember.setCabin(member.getCabin());
            memberRepository.save(newMember);
            return "Modified";
        }

        return "Error updating";
    }

    @DeleteMapping(path="/members/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteMemberById(@PathVariable("id") int id) {
        memberRepository.deleteById(id);
        return "Deleted";
    }

}
//69521100
//70372190 --numero secreto