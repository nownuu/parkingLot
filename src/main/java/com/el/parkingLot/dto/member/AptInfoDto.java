package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.AptEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AptInfoDto {
    private Long amNum; //auto_increment
    private String aptName;
    private String aptDong;
    private String aptHo;

    public static AptInfoDto toaptInfoDto(AptEntity aptEntity){
        AptInfoDto aptInfoDto = new AptInfoDto();
        aptInfoDto.setAmNum(aptEntity.getAmNum());
        aptInfoDto.setAptName(aptEntity.getAptName());
        aptInfoDto.setAptDong(aptEntity.getAptDong());
        aptInfoDto.setAptHo(aptEntity.getAptHo());
        return aptInfoDto;
    }
}
