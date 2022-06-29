package com.aafcj.checkin.dto;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.Role;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;


@Data
@Builder
public class MemberDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    private Gender gender;

    @NotNull
    private int paid;

    private String cabin;

    private Role role;

}
