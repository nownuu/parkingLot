package com.el.parkingLot.dto.member;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private AptInfoDto aptInfoDto = new AptInfoDto();
    private CarInfoDto carInfoDto = new CarInfoDto();
    private String memberName;
    private String memberPhone;
}
