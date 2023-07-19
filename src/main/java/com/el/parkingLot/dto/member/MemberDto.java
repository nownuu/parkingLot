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
    private long memberNum;
    private AptInfoDto aptInfoDto;
    private CarInfoDto carInfoDto;
    private long amNum;
    private long cmNum;
    private String memberName;
    private String memberPhone;


    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberNum(memberEntity.getMemberNum());
        memberDto.setAptInfoDto(AptInfoDto.fromAptEntity(memberEntity.getAptEntity()));
        memberDto.setCarInfoDto(CarInfoDto.fromCarEntity(memberEntity.getCarEntity()));
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberPhone(memberEntity.getMemberPhone());

        // amNum 설정
        if (memberEntity.getAptEntity() != null) {
            memberDto.setAmNum(memberEntity.getAptEntity().getAmNum());
        }

        // cmNum 설정
        if (memberEntity.getCarEntity() != null) {
            memberDto.setCmNum(memberEntity.getCarEntity().getCmNum());
        }

        // aptInfoDto 값 로깅
        System.out.println("aptInfoDto: " + memberDto.getAptInfoDto());

        return memberDto;
    }

    public long getAmNum() {
        if (aptInfoDto != null) {
            return aptInfoDto.getAmNum();
        }
        return 0L;
    }

    public long getCmNum() {
        if (carInfoDto != null) {
            return carInfoDto.getCmNum();
        }
        return 0L;
    }

}
