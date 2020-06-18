package com.mykytam.courseapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}
