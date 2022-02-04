package com.example.demo.handlers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private String message;
    private String path;
    private HttpStatus status;
    private String timestamp;
}