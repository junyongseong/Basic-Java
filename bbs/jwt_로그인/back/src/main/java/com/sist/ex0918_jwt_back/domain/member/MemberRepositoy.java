package com.sist.ex0918_jwt_back.domain.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.ex0918_jwt_back.domain.member.entity.Member;

public interface MemberRepositoy extends JpaRepository<Member,Long>{
    Optional<Member> findByMid(String mid);
}
