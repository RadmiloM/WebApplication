package com.example.WebApplication.service.exception;

public class LanguageNotFoundException extends RuntimeException {
    private String message;

    public LanguageNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
