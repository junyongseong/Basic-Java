package com.swagger.ex_swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserUpdateRequest {

    @Schema(description = "수정할 이메일", example = "update@example.com")
    private String email;

    public UserUpdateRequest() {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
