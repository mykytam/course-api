package com.mykytam.courseapi.exceptions;

public class CourseNotFoundException extends EntityNotFoundException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
