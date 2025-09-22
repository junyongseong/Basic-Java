package com.sist.ex0918_jwt_back.domain.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sist.ex0918_jwt_back.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 아이디로 조회
    Optional<Member> findByMid(String mid);

    // 리프레시 토큰으로 조회
    Optional<Member> findByRefreshToken(String refreshToken);

    // 리프레시 토큰 업데이트
    @Modifying
    @Transactional
    @Query("UPDATE Member m SET m.refreshToken = :refreshToken WHERE m.b_idx  = :b_idx")
    void updateRefreshToken(@Param("b_idx") Long b_idx,
                            @Param("refreshToken") String refreshToken);
}
