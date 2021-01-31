package com.harden.backend_study.global.error.exception;

public class NaverApiRuntimeException extends RuntimeException {

    private ErrorCode errorCode;

    public NaverApiRuntimeException(){
        super();
    }

    public NaverApiRuntimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
