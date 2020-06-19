package com.mykytam.courseapi.exceptions;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {

    @Getter
    private String details;

    public EntityNotFoundException(Integer id) {
        this.details = "Entity not found with id: " + id;
    }
}
