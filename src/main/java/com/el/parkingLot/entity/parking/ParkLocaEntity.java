package com.el.parkingLot.entity.parking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "park_loca")
public class ParkLocaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkLocaId")
    private Long parkLocaId;

    @Column(name = "location")
    private String location; // 주차장 위치

    @Column(name = "temperature")
    private int temperature; // 주차장 온도

    @Column(name = "gas")
    private String gas; // 주차장 가스 정보
}

