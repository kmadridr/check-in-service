package com.aafcj.checkin.entity;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.Role;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int paid;

    @Enumerated(EnumType.STRING)
    private Role role;

}
