package com.example.demo.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Getter
    @AllArgsConstructor
    private class ErrorObject {
        private String error;
        private String message;
        private String path;
        private HttpStatus status;
        private String timestamp;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity handleUsernameNotFoundException(RuntimeException e, WebRequest request){
        ErrorObject errorObject = new ErrorObject("Unauthorized", e.getMessage(),
                ((ServletWebRequest)request).getRequest().getRequestURI(), HttpStatus.UNAUTHORIZED, new Date().toString());
        return handleExceptionInternal(e, errorObject, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

}
