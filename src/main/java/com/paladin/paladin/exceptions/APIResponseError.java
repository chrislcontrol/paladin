package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;

public abstract class APIResponseError extends Exception {
    final public String message;
    final public String code;
    final public HttpStatus status;

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public APIResponseError(String message, HttpStatus status, String code) {
        super(message);
        this.message = (message == null) ? this.defaultMessage() : message;
        this.status = (status == null) ? this.defaultStatus() : status;
        this.code = (code == null) ? this.defaultCode() : code;
    }
    abstract String defaultMessage();
    abstract String defaultCode();
    abstract HttpStatus defaultStatus();
}
