package com.nhnacademy.Resident.exception;

public class ResidentNotFoundException extends RuntimeException {
    public ResidentNotFoundException(String message) {
        super(message);
    }
}
