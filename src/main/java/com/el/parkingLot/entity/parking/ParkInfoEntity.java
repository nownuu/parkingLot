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
@Table(name = "parkInfo")
public class ParkInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pcInfo")
    private Long pcInfo;

    @ManyToOne
    @JoinColumn(name = "memberNum", nullable = false)
    private MemberEntity memberEntity;

    @OneToMany(mappedBy = "parkInfoEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParkLocaEntity> parkLocaEntityList;

    @JsonIgnore
    public List<ParkLocaEntity> getParking() {
        return parkLocaEntityList;
    }

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


}
