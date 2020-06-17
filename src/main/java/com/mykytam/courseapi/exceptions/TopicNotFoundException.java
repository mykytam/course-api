package com.mykytam.courseapi.exceptions;

public class TopicNotFoundException extends EntryNotFoundException {
    public TopicNotFoundException(String message) {
        super(message);
    }
}
