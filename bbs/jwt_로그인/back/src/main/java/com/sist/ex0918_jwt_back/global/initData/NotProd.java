package com.sist.ex0918_jwt_back.global.initData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sist.ex0918_jwt_back.domain.bbs.entity.service.BbsService;
import com.sist.ex0918_jwt_back.domain.member.entity.Member;
import com.sist.ex0918_jwt_back.domain.member.service.MemberService;

@Configuration
@Profile({"dev","test"}) //aplication.yml의 profiles가 dev일때만 움직임
public class NotProd {
    //가짜 데이터(개발 때만 미리 데이터들 넣어주기 위함)
    @Bean
    CommandLineRunner initData(BbsService bbsService,
    MemberService memberService,PasswordEncoder passwordEncoder){//의미 없는 빈 객체

        String pwd= passwordEncoder.encode("1111");
        Member mem3 = memberService.join("maru","마루치",pwd);
        Member mem4 = memberService.join("admin","관리자",pwd);
        return args -> {
            bbsService.create("제목1", "일루치", "테스트입니다1.");
            bbsService.create("제목2", "이루치", "테스트입니다2.");
            bbsService.create("제목3", "삼루치", "테스트입니다3.");
            bbsService.create("제목4", "사루치", "테스트입니다4.");
        };
    }
}
