package com.swagger.ex_swagger.controller;

import com.swagger.ex_swagger.dto.UserCreateRequest;
import com.swagger.ex_swagger.dto.UserUpdateRequest;
import com.swagger.ex_swagger.dto.UserResponse;
import com.swagger.ex_swagger.dto.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User", description = "사용자 관리 API (테스트용 최소 구현)")
@RestController
@RequestMapping("/api/users")
public class UserController {

    // 목록 조회 (간단 목업)
    @Operation(summary = "사용자 목록 조회")
    @ApiResponse(responseCode = "200", description = "조회 성공",
        content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @GetMapping
    public ResponseEntity<List<UserResponse>> list() {
        return ResponseEntity.ok(List.of(
            new UserResponse(1L, "foo@example.com", "ACTIVE"),
            new UserResponse(2L, "bar@example.com", "INACTIVE")
        ));
    }

    // 단건 조회 (간단 목업)
    @Operation(summary = "사용자 조회")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공",
            content = @Content(schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "404", description = "사용자 없음",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(
            @Parameter(description = "사용자 ID", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(new UserResponse(id, "test@example.com", "ACTIVE"));
    }

    // 생성 (요청 바디 역직렬화 위해 DTO에 기본 생성자 필수)
    @Operation(summary = "사용자 생성")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "생성 성공",
            content = @Content(schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "400", description = "잘못된 요청",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest request) {
        UserResponse res = new UserResponse(3L, request.getEmail(), "ACTIVE");
        return ResponseEntity.status(201).body(res);
    }

    // 수정
    @Operation(summary = "사용자 수정(이메일)")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "수정 성공",
            content = @Content(schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "404", description = "사용자 없음",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @Parameter(description = "사용자 ID", example = "1") @PathVariable Long id,
            @RequestBody UserUpdateRequest request) {
        UserResponse res = new UserResponse(id, request.getEmail(), "ACTIVE");
        return ResponseEntity.ok(res);
    }

    // 삭제
    @Operation(summary = "사용자 삭제")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "삭제 성공"),
        @ApiResponse(responseCode = "404", description = "사용자 없음",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
