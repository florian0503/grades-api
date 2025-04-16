package com.example.gradesApi.expectations;

public class ResourceMissingException extends RuntimeException {
    public ResourceMissingException(String message) {
        super(message);
    }
}
