package com.mykytam.courseapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;
}
