package com.sist.ex0918_jwt_back.global.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sist.ex0918_jwt_back.domain.member.service.MemberService;
import com.sist.ex0918_jwt_back.global.result.ResultData;
import com.sist.ex0918_jwt_back.global.service.RequestService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final MemberService memberService;
    private final RequestService requestService;

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
        // String accessToken = null;


        //accessToken검증 또는 refreshToken발급
        String accessToken = requestService.getCookie("accessToken");

        //비어있지 않다면~ 토큰 만료 여부 등등 확인
        if(!accessToken.isBlank()){
            //accessToken이 만료 되었는지 알아내고, 만료되었다면 refreshToken을 얻어내어
            //검증을 한 후 accessToken을 받아낸다.
            //true가 아닐때
            if(!memberService.validateToken(accessToken)){
                //accessToken이 만료 된 경우 refreshToken을 얻어내야한다.
                String refreshToken = requestService.getCookie("refreshToken");

                ResultData<String> resultData =
                memberService.refreshAccessToken(refreshToken);

                requestService.setHeaderCookie("accessToken",
                resultData.getData());
                accessToken= resultData.getData();
            }

            JwtUser jwtUser = memberService.getUserFromAccessToken(accessToken);

            //웨서 받은 jwtUser라는 객체를 이제 인가처리 해줘야함 ****중요****
            requestService.setMember(jwtUser);
        }
        filterChain.doFilter(request,response);
    }

}
