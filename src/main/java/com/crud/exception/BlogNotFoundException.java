package com.crud.exception;

public class BlogNotFoundException extends RuntimeException {

    String message;

    public BlogNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public BlogNotFoundException() {
    }
}
