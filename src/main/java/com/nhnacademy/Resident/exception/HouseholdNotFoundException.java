package com.nhnacademy.Resident.exception;

public class HouseholdNotFoundException extends RuntimeException {
    public HouseholdNotFoundException(String message) {
        super(message);
    }
}
