package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "carInfo_table")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long cmNum;

    @Column(unique = true)
    private String carNum;

    @Column
    private String batValue;

    @Column
    private String carColor;

    public static CarEntity toCarEntity(CarInfoDto carInfoDto){
        CarEntity carEntity = new CarEntity();
        carEntity.setCmNum(carInfoDto.getCmNum());
        carEntity.setCarNum(carInfoDto.getCarNum());
        carEntity.setBatValue(carInfoDto.getBatValue());
        carEntity.setCarColor(carInfoDto.getCarColor());

        return carEntity;
    }
}
