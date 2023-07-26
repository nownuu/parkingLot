package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
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

    @JsonIgnore // JSON 직렬화 시 무한루프 방지
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmNum")
    private ParkInfoEntity parkInfoEntity;

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
