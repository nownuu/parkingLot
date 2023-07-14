package com.el.parkingLot.dto.parking;

import java.sql.Timestamp;

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
    private int pcInfo;
    private int memberNum; //fk
    private String amNum; //fk
    private String pLocation; //fk
    private int cmNum; //fk
    private Timestamp inCar;
    private Timestamp outCar;
}
