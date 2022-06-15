package com.aafcj.checkin.repository;

import com.aafcj.checkin.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
