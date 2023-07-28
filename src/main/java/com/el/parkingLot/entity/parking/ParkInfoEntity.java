package com.el.parkingLot.entity.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.entity.member.AptEntity;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parkInfo")
public class ParkInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcInfo")
    private Long pcInfo; // 주차번호 PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memNum", nullable = false)
    private MemberEntity member; // 회원번호 FK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amNum", nullable = false)
    private AptEntity aptEntity; // 아파트관리번호 FK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pLocation", nullable = false)
    private ParkLocaEntity parkLocaEntity; // 위치 FK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmNum", nullable = false)
    private CarEntity carEntity; // 차량 관리번호 FK

    @Column(name = "inCar")
    private Timestamp inCar; // 입차시간

    @Column(name = "outCar")
    private Timestamp outCar; // 출차시간
}
