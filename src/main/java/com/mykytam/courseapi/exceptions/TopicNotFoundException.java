package com.mykytam.courseapi.exceptions;

public class TopicNotFoundException extends EntityNotFoundException {
    public TopicNotFoundException(String message) {
        super(message);
    }
}
