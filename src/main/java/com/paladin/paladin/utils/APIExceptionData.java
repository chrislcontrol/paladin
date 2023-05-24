package com.paladin.paladin.utils;

public class APIExceptionData {
    private String message;
    private String code;

    private APIExceptionData() {}


    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public static final class Builder {
        private String message;
        private String code;
        private String status;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public APIExceptionData build() {
            APIExceptionData exceptionResponseEntity = new APIExceptionData();
            exceptionResponseEntity.message = this.message;
            exceptionResponseEntity.code = this.code;
            return exceptionResponseEntity;
        }
    }
}
