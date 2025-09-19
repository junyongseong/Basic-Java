package com.sist.ex0918_jwt_back.global.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Override
    @SneakyThrows//try catch로 예외 처리 해야할것을.. 명시적 예외처리를
    //생략 할 수 있도록 한다. 즉 try-catch 사용 안해도 됨
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //아래와 같이 요청했을떄
        if (request.getRequestURI().equals("/api/members/login")
                || request.getRequestURI().equals("api/members/logout")) {
                    filterChain.doFilter(request, response);
                    return;
        }//로그인 또는 로그아웃은 통과해라!!

        //accessToken검증과 refreshToken발급
        String accessToken = null;

        if(accessToken.isBlank()){
            //나중에
        }

        filterChain.doFilter(request,response);
    }

}
