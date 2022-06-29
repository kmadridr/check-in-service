package com.aafcj.checkin.entity;

import com.aafcj.checkin.Gender;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ChurchEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String pastor;

    @ManyToOne
    private SectorEntity sector;

}
