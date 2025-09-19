package com.sist.ex0918_jwt_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex0918JwtBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex0918JwtBackApplication.class, args);
	}

}
