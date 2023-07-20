package com.el.parkingLot.dto.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long memberNum;
    private AptInfoDto aptInfoDto = new AptInfoDto(); // 초기화
    private CarInfoDto carInfoDto = new CarInfoDto(); // 초기화
    private String memberName;
    private String memberPhone;

    public MemberDto(Long memberNum, String memberName, String memberPhone) {
        this.memberNum = memberNum;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
    }

    // AptInfoDto로부터 amNum 값을 가져오는 메서드
    public Long getAmNum() {
        if (aptInfoDto != null) {
            return aptInfoDto.getAmNum();
        }
        return null; // null로 변경
    }

    public Long getCmNum() {
        if (carInfoDto != null) {
            return carInfoDto.getCmNum();
        }
        return null; // null로 변경
    }
}
