package com.swagger.ex_swagger.controller;

import com.swagger.ex_swagger.dto.*;

import io.swagger.v3.oas.annotations.Operation; // OpenAPI 어노테이션
import io.swagger.v3.oas.annotations.tags.Tag;  // 태그(그룹)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Hello", description = "헬로 API")
@RestController
public class HelloController {

    @Operation(summary = "헬로 메시지", description = "간단한 메시지를 반환합니다.")
    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello, Swagger!", "용준");
    }
}