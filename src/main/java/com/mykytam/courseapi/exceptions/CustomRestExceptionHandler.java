package com.mykytam.courseapi.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE) //  defines the sorting order of an annotated component or bean
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    // MissingServletRequestParameterException: This exception is thrown when request missing parameter
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        String error = ex.getParameterName() + " parameter is missing";

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    // MethodArgumentTypeMismatchException: This exception is thrown when method argument is not the expected type
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiError> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    //EntityNotFoundException: Entity with certain id not found in DB
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ApiError> entityNotFoundHandler(EntityNotFoundException ex) {
        String error = ex.getDetails();
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, error, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
