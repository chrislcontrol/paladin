package com.paladin.paladin.utils;

import com.paladin.paladin.exceptions.APIResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(APIResponseError.class)
    public ResponseEntity<?> handleAPIResponseError(APIResponseError exc) {
        APIExceptionData apiExceptionData = APIExceptionData.Builder
                .newBuilder()
                .message(exc.getMessage())
                .code(exc.getCode())
                .build();

        return new ResponseEntity<>(apiExceptionData, exc.getStatus());
    }
}
