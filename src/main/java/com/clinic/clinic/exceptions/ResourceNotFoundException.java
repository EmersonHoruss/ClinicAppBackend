package com.clinic.clinic.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Class clazz, Long id) {
        super("Resource " + clazz.getSimpleName() + " with id " + id + " not found");
    }
}
