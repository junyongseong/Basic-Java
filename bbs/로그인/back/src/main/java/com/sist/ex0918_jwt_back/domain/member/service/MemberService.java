package com.sist.ex0918_jwt_back.domain.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.ex0918_jwt_back.domain.member.MemberRepository;
import com.sist.ex0918_jwt_back.domain.member.entity.Member;
import com.sist.ex0918_jwt_back.global.jwt.JwtProvider;
import com.sist.ex0918_jwt_back.global.result.ResultData;
import com.sist.ex0918_jwt_back.global.security.JwtUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository mRepositoy;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;//암호화 구분하는놈

    public Member join(String mid,String mname, String mpwd){
        Member mem = Member.builder()
        .mid(mid)
        .mname(mname)
        .mpwd(mpwd)
        .build();

        return mRepositoy.save(mem);
    }
    public Member authAndMakeToken(String mid, String mpwd){

        Member member = null;
        String accessToken = null;

        try {
            member = mRepositoy.findByMid(mid).orElseThrow(()->
            new RuntimeException("존재하지 않는 ID입니다."));

            //위는 mid값만 가지고 검색한 Member이므로 다시 비밀번호가 맞는건지
            //확인해야한다.
            if(passwordEncoder.matches(mpwd, member.getMpwd())){
            //여기는 위의RuntimeException이 발생 하지 않을때만 수행함
            //회원 정보를 가지고 토큰 생성
            Map<String,Object> map = new HashMap<>();
            map.put("idx",member.getB_idx());
            map.put("mid",member.getMid());
            map.put("mname",member.getMname());
            // map.put("mpwd",member.getMpwd());//토큰에 넣는것은 좋지 않다.
            map.put("write_date",member.getWrite_date());

            //accessToken = jwtProvider.genToken(map, 60*60); //1시간
            accessToken = jwtProvider.getAccessToken(map); //1시간
            // String refresToken = jwtProvider.genToken(map, 60*60*3);
            String refresToken = jwtProvider.getRefreshToken(map);

            member.setAccessToken(accessToken);//토큰을 만들어 멤버에 저장한다.
            member.setRefreshToken(refresToken);//여기도 마찮가지
            //이 토큰 호출은 Controller에서 한다.

            //DB에 UPDATE할거면 여기서 해도 된다.
            mRepositoy.updateRefreshToken(member.getB_idx(), refresToken);

            }//if문의 끝
            else{
                member= null;
            }
        } catch (Exception e) {
        }
        System.out.println("ACCESSTOKEN"+accessToken);

        return member;
    }
    public ResultData<String> refreshAccessToken(String refreshtoString){
        Member member = null;

        member= mRepositoy.findByRefreshToken(refreshtoString).orElseThrow(()->
        new RuntimeException("존재하지 않는 ID"));

        //토큰 생성할때 넣어줄 payload값들 준비
        Map<String, Object> map = new HashMap<>();
        map.put("idx",member.getB_idx());
        map.put("nid",member.getMid());
        map.put("mname",member.getMname());
        map.put("write_date",member.getWrite_date());

        String accessToken = jwtProvider.getAccessToken(map);
        //요청한 곳으로 보낼  Json자원 준비
        int cnt =0;
        String msg ="fail";
        if(member != null){ //즉 값이 들어왔다는 이야기
            cnt=1;
            msg="success";
        }
        return ResultData.of(cnt,msg,accessToken); //RestController니
        //얘네가 던져질땐 json으로 나감
    }
    public JwtUser getUserFromAccessToken(String accessToken){
        //인자로 받은 jwt accessToken으로부터 payload만 받는다.
        Map<String,Object> payload = jwtProvider.getCalims(accessToken);

        String mid = (String)payload.get("mid");
        String mname = (String)payload.get("mname");
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new JwtUser(mid, mname,"",authorities);
    }
    public boolean validateToken(String token){
        return jwtProvider.verify(token);
    }
}
