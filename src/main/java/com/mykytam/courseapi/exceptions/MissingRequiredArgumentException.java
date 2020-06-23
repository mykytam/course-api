package com.mykytam.courseapi.exceptions;

public class MissingRequiredArgumentException extends RuntimeException {
    public MissingRequiredArgumentException(String message) {
        super(message);
    }
}
