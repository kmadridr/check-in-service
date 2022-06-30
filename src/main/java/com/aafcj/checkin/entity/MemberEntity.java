package com.aafcj.checkin.entity;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.Role;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class MemberEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int paid;

    @ManyToOne
    private ChurchEntity church;

    @Enumerated(EnumType.STRING)
    private Role role;

}
