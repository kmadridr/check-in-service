package com.aafcj.checkin.dto;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;


@Data
@Builder
public class MemberDTO {

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String gender;

    @NotNull
    private int paid;

    @NotNull
    private String role;

}
