package com.aafcj.checkin.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(int id) {
        super(String.format("Member not found with ID %d", id));
    }
}
