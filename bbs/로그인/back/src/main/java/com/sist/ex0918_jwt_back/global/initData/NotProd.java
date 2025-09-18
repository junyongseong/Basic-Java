package com.sist.ex0918_jwt_back.global.initData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sist.ex0918_jwt_back.domain.bbs.entity.service.BbsService;

@Configuration
@Profile({"dev","test"}) //aplication.yml의 profiles가 dev일때만 움직임
public class NotProd {
    //가짜 데이터(개발 때만 미리 데이터들 넣어주기 위함)

    @Bean
    CommandLineRunner initData(BbsService bbsService){//의미 없는 빈 객체
        return args -> {
            bbsService.create("제목1", "일루치", "테스트입니다1.");
            bbsService.create("제목2", "이루치", "테스트입니다2.");
            bbsService.create("제목3", "삼루치", "테스트입니다3.");
            bbsService.create("제목4", "사루치", "테스트입니다4.");
        };
    }
}
