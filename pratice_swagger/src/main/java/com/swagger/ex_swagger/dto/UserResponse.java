package com.swagger.ex_swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserResponse {

    @Schema(description = "사용자 ID", example = "1")
    private Long id;

    @Schema(description = "이메일", example = "test@example.com")
    private String email;

    @Schema(description = "계정 상태", example = "ACTIVE")
    private String status;

    public UserResponse() {}

    public UserResponse(Long id, String email, String status) {
        this.id = id;
        this.email = email;
        this.status = status;
    }

    // getter/setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
