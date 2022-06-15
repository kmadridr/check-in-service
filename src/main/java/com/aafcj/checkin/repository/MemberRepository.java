package com.aafcj.checkin.repository;

import com.aafcj.checkin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
