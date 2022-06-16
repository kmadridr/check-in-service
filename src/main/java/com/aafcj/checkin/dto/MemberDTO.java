package com.aafcj.checkin.dto;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.Role;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
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
