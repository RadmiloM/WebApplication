package com.example.WebApplication.service.exception;

public class WrongDataEntryException extends RuntimeException {
    private String message;

    public WrongDataEntryException(String message) {
        super(message);
        this.message = message;
    }

}
