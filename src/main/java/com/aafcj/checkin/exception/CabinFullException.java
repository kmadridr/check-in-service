package com.aafcj.checkin.exception;

public class CabinFullException extends RuntimeException {

    public CabinFullException(String name) {
        super(String.format("Cabin %s have reached it's capacity", name));
    }
}
