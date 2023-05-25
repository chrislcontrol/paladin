package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;


public class InvalidCredentials extends APIResponseError {
    public InvalidCredentials(String message, HttpStatus status, String code) {
        super(message, status, code);
    }

    @Override
    String defaultMessage() {
        return "It was not possible to log in with provided credentials.";
    }

    @Override
    String defaultCode() {
        return "INVALID_CREDENTIALS";
    }

    @Override
    HttpStatus defaultStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
