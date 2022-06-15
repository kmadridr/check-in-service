package com.aafcj.checkin.entity;

import com.aafcj.checkin.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cabin {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private int capacity;

    @OneToMany
    private List<Member> members;

    private Gender gender;

    private boolean pastor;

    private boolean toilet;

}
