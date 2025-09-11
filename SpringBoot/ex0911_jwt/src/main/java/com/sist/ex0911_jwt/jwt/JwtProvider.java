package com.sist.ex0911_jwt.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    
    @Value("${custom.jwt.secretKey}")
    private String secretKeyCode;

    private SecretKey secretKey;
    
    public SecretKey getSecretKey() {
        if(secretKey == null){
            String encoding = Base64.getEncoder().encodeToString(secretKeyCode.getBytes());
    
            //secreteKey는 숫자와 문자들을 본인 마음대로 길게 기술 한 것이다.(별 의미없이 기술)
            //그 값(secretKeyCode)을 가지고 jwt키를 만들어야 한다. 이때
            //jjw라는 라이브러리를 사용하면 편하다! 
            secretKey = Keys.hmacShaKeyFor(encoding.getBytes());

        }

            return secretKey;
    }
    public String getToken(Map<String, Object> map, int seconds){
        long now = new Date().getTime();

        Date accessTokenExpirsIn = new Date(now+1000L*seconds);
        //1000L *seconds : 밀리초로 변환 -만료시간 
        JwtBuilder jwtBuilder =  Jwts.builder().subject("SIST")
        .expiration(accessTokenExpirsIn);

        Set<String> keys = map.keySet();//반복자 처리하기 위해 set구조화

        Iterator<String> it = keys.iterator();
        while(it.hasNext()){ //hasnext 다음게 있는지
            String key = it.next();
            Object value = map.get(key);

            jwtBuilder.claim(key, value);
            /*
             JWT는 (JSON Web Token)은 크게 3가지 영역으로 나뉜다.
                1.Header(알고리즘, 타입)
                2.PayLoad(데이터)
                3.Signature
                이중 Payload안에 들어있는 정보(data)단위를 Claim이라고 한다.
             */
        }//반복문의 끝
        String jwt = jwtBuilder.signWith(getSecretKey()).compact();
        return jwt;
    }
    //토큰이 만료되었는지? 확인
    public boolean verify(String token){
        boolean value = true;

        try {
            Jwts.parser().verifyWith(getSecretKey())//동일한 시크릿키 
            .build().parseSignedClaims(token);//만료 되었는지 확인 
        } catch (Exception e) {
            //유효기간이 만료되면 예외 발생
            value = false;
        }
        return value;
    }
    //토큰에 담긴 사용자 정보(claims)를 반환한다.
    public Map<String, Object> getCalims(String token){
        return Jwts.parser().verifyWith(getSecretKey()).build()
        .parseSignedClaims(token).getPayload();
    }
}

