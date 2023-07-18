package com.el.parkingLot.entity.member;

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
    private Long memberNum;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "amNum", referencedColumnName = "amNum")
    private AptEntity aptEntity;
//    private AptEntity amNum; //fk

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cmNum", referencedColumnName = "cmNum")
    private CarEntity carEntity; //fk

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberNum(memberDto.getMemberNum());
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());
        return memberEntity;
    }
}
