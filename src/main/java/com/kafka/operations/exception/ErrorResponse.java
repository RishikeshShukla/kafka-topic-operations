package com.kafka.operations.exception;

public class ErrorResponse {

    private String message;
    private String errorStrCode;

    public ErrorResponse(String message, String errorStrCode) {
        this.message = message;
        this.errorStrCode = errorStrCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorStrCode() {
        return errorStrCode;
    }

    public void setErrorStrCode(String errorStrCode) {
        this.errorStrCode = errorStrCode;
    }
}
