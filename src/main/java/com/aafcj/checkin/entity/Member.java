package com.aafcj.checkin.entity;

import com.aafcj.checkin.Gender;
import com.aafcj.checkin.Role;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String lastName;

    private Gender gender;

    @ManyToOne
    private Cabin cabin;

    private int paid;

    private Role role;

}
