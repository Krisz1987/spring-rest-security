package com.chriscoding.springrestsecurity.advice;

import com.chriscoding.springrestsecurity.domain.response.ErrorResponse;
import com.chriscoding.springrestsecurity.exception.RoleNotFoundException;
import com.chriscoding.springrestsecurity.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserException(Exception e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(100, e.getMessage());
        return response;
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ErrorResponse handleRoleException(Exception e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(101, e.getMessage());
        return response;
    }
}
