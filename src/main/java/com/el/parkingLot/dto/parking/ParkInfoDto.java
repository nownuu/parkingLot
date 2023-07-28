package com.el.parkingLot.dto.parking;

import java.sql.Timestamp;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import lombok.*;


/*create table parkInfo(
	pcInfo int NOT NULL AUTO_INCREMENT,
    memberNum int NOT NULL,
    amNum char(5) NOT NULL,
    pLocation char(2) NOT NULL,
    cmNum int NOT NULL,
    inCar timestamp,
    outCar timestamp,

    PRIMARY KEY(pcInfo),
    FOREIGN KEY(memNum) references member(memberNum),
    FOREIGN KEY(amNum) references aptInfo(amNum),
    FOREIGN KEY(pLocation) references parkLoca(pLocation),
    FOREIGN KEY(cmNum) references carInfo(cmNum)
);*/
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
