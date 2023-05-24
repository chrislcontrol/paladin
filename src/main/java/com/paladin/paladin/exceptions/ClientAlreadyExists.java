package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;

public class ClientAlreadyExists extends APIResponseError {

    public ClientAlreadyExists(String message, HttpStatus status, String code) {
        super(message, status, code);
    }

    @Override String defaultMessage() {
        return "Client already exists.";
    }

    @Override String defaultCode() {
        return "CLIENT_ALREADY_EXISTS";
    }
    @Override HttpStatus defaultStatus() {
        return HttpStatus.CONFLICT;
    }
}
