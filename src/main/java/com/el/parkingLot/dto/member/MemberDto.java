package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long memberNum;
    private AptInfoDto aptInfoDto;
    private CarInfoDto carInfoDto;
    private String memberName;
    private String memberPhone;

    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberNum(memberEntity.getMemberNum());
        memberDto.setAptInfoDto(AptInfoDto.fromAptEntity(memberEntity.getAptEntity()));
        memberDto.setCarInfoDto(CarInfoDto.fromCarEntity(memberEntity.getCarEntity()));
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberPhone(memberEntity.getMemberPhone());
        return memberDto;
    }
}
