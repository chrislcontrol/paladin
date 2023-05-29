package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;

public abstract class APIResponseError extends RuntimeException {
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

    public APIResponseError(String message, HttpStatus status) {
        super(message);
        this.message = (message == null) ? this.defaultMessage() : message;
        this.status = (status == null) ? this.defaultStatus() : status;
        this.code = this.defaultCode();
    }

    public APIResponseError(String message) {
        super(message);
        this.message = (message == null) ? this.defaultMessage() : message;
        this.status = this.defaultStatus();
        this.code = this.defaultCode();
    }

    abstract String defaultMessage();

    abstract String defaultCode();

    abstract HttpStatus defaultStatus();
}
