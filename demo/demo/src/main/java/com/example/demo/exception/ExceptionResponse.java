package com.example.demo.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String message;
    private String code;
    private LocalDateTime timestamp;
    private String path;

    public ExceptionResponse(String message, String code, String path) {
        this.message = message;
        this.code = code;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}
