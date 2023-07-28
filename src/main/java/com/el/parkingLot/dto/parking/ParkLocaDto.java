package com.el.parkingLot.dto.parking;

import com.el.parkingLot.entity.parking.ParkLocaEntity;
import lombok.*;
/*create table parkLoca(
	pLocation char(2) NOT NULL check(pLocation='1A' or pLocation='2A' or pLocation = '1B' or pLocation = '2B'),
    temp int NOT NULL,
    gas varchar(3) default 'off' NOT NULL check(gas in ('on', 'off')),
    PRIMARY KEY(pLocation)
);*/
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ParkLocaDto {
    private String pLocation;
    private int temp;
    private String gas;

    public static ParkLocaDto toParkLocaDto(ParkLocaEntity parkLocaEntity) {
        ParkLocaDto parkLocaDto = new ParkLocaDto();
        parkLocaDto.setPLocation(parkLocaEntity.getLocation());
        parkLocaDto.setTemp(parkLocaEntity.getTemperature());
        parkLocaDto.setGas(parkLocaEntity.getGas());
        return parkLocaDto;
    }
}
