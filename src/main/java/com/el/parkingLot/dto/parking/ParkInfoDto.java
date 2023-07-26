package com.el.parkingLot.dto.parking;

import java.sql.Timestamp;

import com.el.parkingLot.dto.member.MemberDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParkInfoDto {
    private Long pcInfo;
    private MemberDto memberDto = new MemberDto();

    // 외래키
    private ParkLocaDto parkLocaDto = new ParkLocaDto();

    private Timestamp inCar; // 입차
    private Timestamp outCar; // 출차

    public void setParkLocaDto(ParkLocaDto parkLocaDto) {
        this.parkLocaDto = parkLocaDto;
    }
}
