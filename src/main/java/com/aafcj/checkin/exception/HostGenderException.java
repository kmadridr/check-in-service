package com.aafcj.checkin.exception;

import com.aafcj.checkin.Gender;

public class HostGenderException extends RuntimeException {

    public HostGenderException(String cabinName, Gender cabinGender, String memberName, Gender memberGender) {
        super(String.format("The cabin %s is for %s gender. Member %s is a %s", cabinName, cabinGender, memberName, memberGender));
    }
}
