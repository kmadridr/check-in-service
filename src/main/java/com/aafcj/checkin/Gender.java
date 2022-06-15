package com.aafcj.checkin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Gender {
    MALE("male"),
    FEMALE("female");

    private String value;
    Gender(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Gender fromString(String value) {
        return Gender.valueOf(value.toUpperCase());
    }

    @JsonValue
    private String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
