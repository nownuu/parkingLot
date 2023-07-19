package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.CarEntity;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
public class CarInfoDto {
//    private Long cmNum; //auto_increment
    private String carNum;
    private String batValue;
    private String carColor;

    public CarInfoDto(){}

    public CarInfoDto(String carNum, String batValue, String carColor){
        this.carNum = carNum;
        this.batValue = batValue;
        this.carColor = carColor;
    }
}
