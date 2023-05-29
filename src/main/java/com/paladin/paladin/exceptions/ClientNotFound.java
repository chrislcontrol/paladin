package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;

public class ClientNotFound extends APIResponseError{
    public ClientNotFound(String message, HttpStatus status, String code) {
        super(message, status, code);
    }

    @Override
    String defaultMessage() {
        return "Client not found";
    }

    @Override
    String defaultCode() {
        return "CLIENT_NOT_FOUND";
    }

    @Override
    HttpStatus defaultStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
