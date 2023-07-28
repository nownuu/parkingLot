package com.el.parkingLot.entity.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
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
@Table(name = "parkLoca")
public class ParkLocaEntity {
    @Id
    @Column(name = "pLocation", length = 2)
    private String pLocation; // 주차장 위치 (e.g., "1A", "2A", "1B", "2B")

    @Column(name = "temp", nullable = false)
    private int temp; // 주차장 온도

    @Column(name = "gas", nullable = false, length = 3)
    private String gas; // 주차장 가스 정보 ("on" 또는 "off")
}
