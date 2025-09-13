package com.swagger.ex_swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserCreateRequest {

    @Schema(description = "이메일(고유)", example = "test@example.com")
    private String email;

    @Schema(description = "비밀번호(8자 이상)", example = "abcd1234")
    private String password;

    // 기본 생성자 (JSON 역직렬화용)
    public UserCreateRequest() {}

    // getter/setter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
