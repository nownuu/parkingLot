package com.el.parkingLot.dto.parking;

import java.sql.Timestamp;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParkInfoDto {
    private Long pcInfo;

    // 외래키
    private MemberDto memberDto = new MemberDto();
    private ParkLocaDto parkLocaDto = new ParkLocaDto();

    private Timestamp inCar; // 입차
    private Timestamp outCar; // 출차

    public static ParkInfoDto toParkInfoDto(ParkInfoEntity parkInfoEntity) {
        ParkInfoDto parkInfoDto = new ParkInfoDto();
        parkInfoDto.setPcInfo(parkInfoEntity.getPcInfo());
        parkInfoDto.setInCar(parkInfoEntity.getInCar());
        parkInfoDto.setOutCar(parkInfoEntity.getOutCar());

        return parkInfoDto;
    }
}

