package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.MemberDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long memberNum;

    @Column
    private String amNum; //fk

    @Column
    private int cmNum; //fk

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberNum(memberDto.getMemberNum());
        memberEntity.setAmNum(memberDto.getAmNum());
        memberEntity.setCmNum(memberDto.getCmNum());
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPhone(memberEntity.getMemberPhone());
        return memberEntity;
    }
}
