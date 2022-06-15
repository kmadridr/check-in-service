package com.aafcj.checkin.entity;

import com.aafcj.checkin.Time;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int fullPrice;
    private String place;
    private String role;
    private Time time;

}
