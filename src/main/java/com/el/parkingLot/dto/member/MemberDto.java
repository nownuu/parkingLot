package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
//    private long id;
    private Long memberNum; //auto_increment
    private String amNum; //fk
    private int cmNum; //fk
    private String memberName;
    private String memberPhone;

    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberNum(memberEntity.getMemberNum());
        memberDto.setAmNum(memberEntity.getAmNum());
        memberDto.setCmNum(memberEntity.getCmNum());
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberPhone(memberEntity.getMemberPhone());
        return memberDto;
    }
}
