package com.aafcj.checkin.entity;

import com.aafcj.checkin.Time;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class PriceEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int fullPrice;
    private String place;
    private String role;

    @Enumerated(EnumType.STRING)
    private Time time;

}
