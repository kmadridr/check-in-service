package com.aafcj.checkin.exception;

public class CabinNotFoundException extends RuntimeException {
    public CabinNotFoundException(String name) {
        super(String.format("Cabin %s not found", name));
    }
}
