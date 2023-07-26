package com.el.parkingLot.dto.parking;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

// 주차장 정보 보기
public class ParkLocaDto {
    private String pLocation;
    private int temp;
    private String gas;
}
