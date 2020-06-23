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

    // Topic with certain id not found in DB
    @ExceptionHandler(TopicNotFoundException.class)
    public ResponseEntity<ApiError> topicNotFoundHandler(TopicNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // Course with certain id not found in DB
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ApiError> topicNotFoundHandler(CourseNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // Student with certain id not found in DB
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiError> topicNotFoundHandler(StudentNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // Validation failed
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodArgumentNotValidHandler(MethodArgumentNotValidException ex) {
        ValidationError validationError = new ValidationError(ex.getBindingResult().getFieldErrors());
        return new ResponseEntity<>(validationError, validationError.getStatus());
    }

    // Missing required argument
    @ExceptionHandler(MissingRequiredArgumentException.class)
    public ResponseEntity<ApiError> missingRequiredArgumentHandler(MissingRequiredArgumentException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
