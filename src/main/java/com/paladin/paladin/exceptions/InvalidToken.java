package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidToken extends APIResponseError{
    public InvalidToken(String message, HttpStatus status, String code) {
        super(message, status, code);
    }

    @Override
    String defaultMessage() {
        return "Invalid token.";
    }

    @Override
    String defaultCode() {
        return HttpStatus.UNAUTHORIZED.getReasonPhrase();
    }

    @Override
    HttpStatus defaultStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
