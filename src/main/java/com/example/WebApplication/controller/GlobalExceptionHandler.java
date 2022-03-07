package com.example.WebApplication.controller;

import com.example.WebApplication.service.exception.LanguageNotFoundException;
import com.example.WebApplication.service.exception.UserNotFoundException;
import com.example.WebApplication.service.exception.WrongDataEntryException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exceptions,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        HashMap<String, String> languageErrors = new HashMap<>();
        exceptions.getBindingResult().getAllErrors().forEach((error) -> {
            String languageFieldError = ((FieldError) error).getField();
            String languageMessage = error.getDefaultMessage();
            languageErrors.put(languageFieldError, languageMessage);

        });
        return new ResponseEntity<Object>(languageErrors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(LanguageNotFoundException.class)
    public ResponseEntity<String> handleLanguageNotFoundException(LanguageNotFoundException languageNotFoundException) {
        return new ResponseEntity<String>(languageNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<String>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongDataEntryException.class)
    public ResponseEntity<String> handleWrongDataEntryException(WrongDataEntryException wrongDataEntryException) {
        return new ResponseEntity<String>(wrongDataEntryException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
