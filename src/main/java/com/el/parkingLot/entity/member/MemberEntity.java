package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.dto.member.MemberDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@Table(name = "member") //테이블명
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //auto_increment
    @Column(name="memberNum")
    private long memberNum;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "amNum", referencedColumnName = "amNum")
    private AptEntity aptEntity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cmNum", referencedColumnName = "cmNum")
    private CarEntity carEntity; // 자동차 정보

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();

        // AptEntity 설정
        AptEntity aptEntity = new AptEntity();
        aptEntity.setAmNum(memberDto.getAmNum());
        memberEntity.setAptEntity(aptEntity);

        // CarEntity 설정
        CarEntity carEntity = new CarEntity();
        carEntity.setCmNum(memberDto.getCmNum());
        memberEntity.setCarEntity(carEntity);

        // 나머지 필드 설정
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());

        return memberEntity;
    }


}
