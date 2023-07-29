package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberNum", nullable = false)
    private Long memberNum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amNum", referencedColumnName = "amNum")
    private AptEntity aptEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cmNum", referencedColumnName = "cmNum")
    private CarEntity carEntity;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_phone")
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();

        // AptEntity - amNum
        AptEntity aptEntity = AptEntity.toAptEntity(
                memberDto.getAptInfoDto());
        memberEntity.setAptEntity(aptEntity);

        // CarEntity - cmNum
        CarEntity carEntity = CarEntity.toCarEntity(
                memberDto.getCarInfoDto());
        memberEntity.setCarEntity(carEntity);

        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());

        return memberEntity;
    }


    // 본인 차량 정보 보기
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CarEntity> cars;

    @JsonIgnore
    public List<CarEntity> getCars() {
        return cars;
    }

    // 본인 차량 주차장 정보 보기
    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParkInfoEntity> parkInfoEntities;


}
