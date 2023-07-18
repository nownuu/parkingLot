package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.AptEntity;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
//@NoArgsConstructor
public class AptInfoDto {
    private Long amNum; //auto_increment
    private String aptName;
    private String aptDong;
    private String aptHo;

    protected AptInfoDto(){

    } //기본 생성자

    public AptInfoDto(String aptName, String aptDong, String aptHo){
        this.aptName = aptName;
        this.aptDong = aptDong;
        this.aptHo = aptHo;
    }

//    public static AptInfoDto toaptInfoDto(AptEntity aptEntity){
//        AptInfoDto aptInfoDto = new AptInfoDto();
//        aptInfoDto.setAmNum(aptEntity.getAmNum());
//        aptInfoDto.setAptName(aptEntity.getAptName());
//        aptInfoDto.setAptDong(aptEntity.getAptDong());
//        aptInfoDto.setAptHo(aptEntity.getAptHo());
//        return aptInfoDto;
//    }
}
