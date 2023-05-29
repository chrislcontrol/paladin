package com.paladin.paladin.exceptions;

import org.springframework.http.HttpStatus;

public class VehicleAlreadyExists extends APIResponseError {
    public VehicleAlreadyExists(String message, HttpStatus status, String code) {
        super(message, status, code);
    }

    public VehicleAlreadyExists(String message, HttpStatus status) {
        super(message, status);
    }

    public VehicleAlreadyExists(String message) {
        super(message);
    }

    public VehicleAlreadyExists() {
        super("Vehicle already exists.");
    }

    @Override
    String defaultMessage() {
        return "Vehicle already exists.";
    }

    @Override
    String defaultCode() {
        return "VEHICLE_ALREADY_EXISTS";
    }

    @Override
    HttpStatus defaultStatus() {
        return HttpStatus.CONFLICT;
    }
}
