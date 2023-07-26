package com.el.parkingLot.dto.parking;

import com.el.parkingLot.entity.parking.ParkLocaEntity;
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

    public static ParkLocaDto fromParkLocaEntity(ParkLocaEntity parkLocaEntity){
        ParkLocaDto parkLocaDto = new ParkLocaDto();
        parkLocaDto.setPLocation(parkLocaEntity.getPLocation());
        parkLocaDto.setTemp(parkLocaEntity.getTemp());
        parkLocaDto.setGas(parkLocaEntity.getGas());

        return parkLocaDto;
    }
}
