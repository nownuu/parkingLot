package com.el.parkingLot.dto.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    // 외래키
    private AptInfoDto aptInfoDto = new AptInfoDto();
    private CarInfoDto carInfoDto = new CarInfoDto();

    private String memberName;
    private String memberPhone;
}
