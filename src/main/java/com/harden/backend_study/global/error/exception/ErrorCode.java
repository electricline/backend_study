package com.harden.backend_study.global.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    // Naver open api
    NAVER_API_UNAUTHORIZED("네이버 오픈 API 통신 중 인증 에러가 발생했습니다."),
    NAVER_API_BAD_REQUEST("잘못된 요청 구문, 또는 유효하지 않은 요청입니다."),
    NAVER_API_ERROR("네이버 오픈 API 통신 중 알수 없는 에러가 발생했습니다."),
    NO_CONTENT("데이터가 없습니다.")
    ;


    private String code;
    private final String message;
    private int status;

    ErrorCode(final String message) { this.message = message;};

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
