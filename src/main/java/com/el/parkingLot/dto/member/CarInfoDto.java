package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.CarEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CarInfoDto {
    private Long cmNum;
    private String carNum;
    private String batValue;
    private String carColor;

    public static CarInfoDto fromCarEntity(CarEntity carEntity){
        CarInfoDto carInfoDto = new CarInfoDto();
        carInfoDto.setCmNum(carEntity.getCmNum());
        carInfoDto.setCarNum(carEntity.getCarNum());
        carInfoDto.setBatValue(carEntity.getBatValue());
        carInfoDto.setCarColor(carEntity.getCarColor());

        return carInfoDto;
    }
}
