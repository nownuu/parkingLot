package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.MemberDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberNum", nullable = false)
    private Long memberNum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amNum", referencedColumnName = "amNum")
    private AptEntity aptEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cmNum", referencedColumnName = "cmNum")
    private CarEntity carEntity;

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    public static MemberEntity toMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();

        // AptEntity - amNum
        AptEntity aptEntity = new AptEntity();
        aptEntity.setAmNum(memberDto.getAmNum());
        memberEntity.setAptEntity(aptEntity);

        // CarEntity -cmNum
        CarEntity carEntity = new CarEntity();
        carEntity.setCmNum(memberDto.getCmNum());
        memberEntity.setCarEntity(carEntity);

        // 나머지 필드 설정
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPhone(memberDto.getMemberPhone());

        return memberEntity;
    }

}
