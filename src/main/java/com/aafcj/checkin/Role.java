package com.aafcj.checkin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Role {
    GENERAL("General"),
    ADVISOR("Advisor"),
    PASTOR("Pastor"),
    USHER("Usher");

    private String value;

    Role(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Role fromString(String value) {
        return Role.valueOf(value.toUpperCase());
    }
    @JsonValue
    private String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return  this.getValue();
    }
}
