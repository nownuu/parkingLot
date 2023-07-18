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
    private Long memberNum;


//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "amNum", referencedColumnName = "amNum")
//    private AptEntity aptEntity;
//    private AptEntity amNum; //fk


//    @JoinColumn(name = "cmNum", referencedColumnName = "cmNum")
//    private CarEntity carEntity; //fk

//    @ManyToOne(cascade = CascadeType.PERSIST)
    @Embedded
    private AptInfoDto aptInfoDto; // 아파트 정보

    @Embedded
    private CarInfoDto carInfoDto; // 자동차 정보

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        AptEntity aptEntity = new AptEntity();
        CarEntity carEntity = new CarEntity();

//        aptEntity.setAmNum(memberDto.getAmNum());
//        carEntity.setCmNum(memberDto.getCmNum());
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());
        return memberEntity;
    }
}
