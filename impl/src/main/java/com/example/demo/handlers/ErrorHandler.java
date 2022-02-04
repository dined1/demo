package com.example.demo.handlers;

import com.example.demo.handlers.models.ErrorResponse;
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

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ResponseEntity handleUsernameNotFoundException(RuntimeException e, WebRequest request){
        ErrorResponse errorObject = new ErrorResponse("Unauthorized", e.getMessage(),
                ((ServletWebRequest)request).getRequest().getRequestURI(), HttpStatus.UNAUTHORIZED, new Date().toString());
        return handleExceptionInternal(e, errorObject, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

}
