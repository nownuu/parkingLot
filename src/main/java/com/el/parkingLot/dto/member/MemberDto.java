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
//    private long id;
    private Long memberNum; //auto_increment
    private Long amNum; //fk
    private Long cmNum; //fk
    private String memberName;
    private String memberPhone;

    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberNum(memberEntity.getMemberNum());
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberPhone(memberEntity.getMemberPhone());
        return memberDto;
    }
}
