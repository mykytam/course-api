package com.mykytam.courseapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomRestExceptionHandler {

    // Entity with certain id not found in DB
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> entityNotFoundHandler(EntityNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // Validation failed
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValidHandler(MethodArgumentNotValidException ex) {
        ValidationError validationError = new ValidationError(ex.getBindingResult().getFieldErrors());
        return new ResponseEntity<>(validationError, validationError.getStatus());
    }
}
