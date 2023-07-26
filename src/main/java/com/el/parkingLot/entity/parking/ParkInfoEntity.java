package com.el.parkingLot.entity.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.entity.member.MemberEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "park_info")
public class ParkInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcInfo")
    private Long pcInfo;

    @ManyToOne
    @JoinColumn(name = "cmNum", nullable = false)
    private MemberEntity memberEntity;

    // 일대다 관계를 정의합니다.
    @OneToMany(mappedBy = "parkInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParkLocaEntity> parkLocaEntityList;

    @Column(name = "inCar")
    private Timestamp inCar;

    @Column(name = "outCar")
    private Timestamp outCar;

    public static ParkInfoEntity toParkInfoEntity(ParkInfoDto parkInfoDto) {
        ParkInfoEntity parkInfoEntity = new ParkInfoEntity();

        // MemberEntity - memberNum, amNum, cmNum
        MemberEntity memberEntity = MemberEntity.toMemberEntity(parkInfoDto.getMemberDto());
        parkInfoEntity.setMemberEntity(memberEntity);

        // ParkEntity - pLocation
        parkInfoEntity.setInCar(parkInfoDto.getInCar());
        parkInfoEntity.setOutCar(parkInfoDto.getOutCar());

        return parkInfoEntity;
    }

    @JsonIgnore
    public List<ParkLocaEntity> getParking() {
        return parkLocaEntityList;
    }
}
