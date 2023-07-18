package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "carInfo")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "cmNum")
    private Long cmNum;

    @Column(unique = true)
    private String carNum;

    @Column
    private String batValue;

    @Column
    private String carColor;

    public static CarEntity toCarEntity(CarInfoDto carInfoDto){
        CarEntity carEntity = new CarEntity();
        carEntity.setCarNum(carInfoDto.getCarNum());
        carEntity.setBatValue(carInfoDto.getBatValue());
        carEntity.setCarColor(carInfoDto.getCarColor());

        return carEntity;
    }
}
