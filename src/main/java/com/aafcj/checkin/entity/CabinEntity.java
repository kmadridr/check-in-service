package com.aafcj.checkin.entity;

import com.aafcj.checkin.Gender;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CabinEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private int capacity;

    @OneToMany
    private List<MemberEntity> members;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean pastor;

    private boolean toilet;

}
