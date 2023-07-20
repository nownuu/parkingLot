package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_info")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmNum")
    private Long cmNum;

    @Column(name = "car_num", unique = true)
    private String carNum;

    @Column(name = "bat_value")
    private String batValue;

    @Column(name = "car_color")
    private String carColor;

    public static CarEntity toCarEntity(CarInfoDto carInfoDto) {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarNum(carInfoDto.getCarNum());
        carEntity.setBatValue(carInfoDto.getBatValue());
        carEntity.setCarColor(carInfoDto.getCarColor());
        return carEntity;
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @JsonIgnore
    public MemberEntity getMember() {
        return member;
    }
}
