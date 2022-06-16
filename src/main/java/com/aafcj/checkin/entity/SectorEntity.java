package com.aafcj.checkin.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SectorEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private int number;

    @OneToMany
    private List<ChurchEntity> churches;


}
