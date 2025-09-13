package com.swagger.ex_swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse {

    @Schema(description = "에러 코드", example = "USER_NOT_FOUND")
    private String code;

    @Schema(description = "에러 메시지", example = "해당 사용자가 존재하지 않습니다.")
    private String message;

    public ErrorResponse() {}

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // getter/setter
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
