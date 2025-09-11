package com.sist.ex0911_jwt;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.ex0911_jwt.jwt.JwtProvider;

import io.jsonwebtoken.security.Keys;

@SpringBootTest
class Ex0911JwtApplicationTests {

	@Value("$(custom.jwt.secretKey)")
	private String secretKeyCode;

	@Test
	@DisplayName("시크릿 키 코드")
	void loadSecretKeyCode() {
		//단언 : assertJ
		assertThat(secretKeyCode).isNotNull();
	}

	@Test
	@DisplayName("암호화 알고리즘으로 시크릿 키 암호화")
	void genBase64(){
		String encoding =
			Base64.getEncoder().encodeToString(secretKeyCode.getBytes());

		SecretKey sKey =Keys.hmacShaKeyFor(encoding.getBytes());
		assertThat(sKey).isNotNull();
	}

	@Autowired
	private JwtProvider jwtProvider;

	@Test
	@DisplayName("acessToken 발급")
	void tokenTest(){
		Map<String, Object> claims = new HashMap<>();
		claims.put("id","admin");
		claims.put("uname","어두일미");
		claims.put("upwd","1234");
		claims.put("email","admin@naver.com");

		String accessToken = jwtProvider.getToken(claims, 60*60*3);
		System.out.println("ACCESSTOKEN:"+accessToken);

		assertThat(accessToken).isNotNull();

	}
}
