package com.aafcj.checkin.dto;

import com.aafcj.checkin.Gender;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class CabinDTO {

    @NotNull
    private Integer id;

    private String name;

    private int capacity;

    private Gender gender;

    private List<MemberDTO> members;
}
