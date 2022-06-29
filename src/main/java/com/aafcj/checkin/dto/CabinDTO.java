package com.aafcj.checkin.dto;

import com.aafcj.checkin.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CabinDTO {

    private String name;

    private int capacity;

    private Gender gender;
}
