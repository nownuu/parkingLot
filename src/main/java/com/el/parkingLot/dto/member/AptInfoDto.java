package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.AptEntity;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
public class AptInfoDto {
    private Long amNum;
    private String aptName;
    private String aptDong;
    private String aptHo;

    public AptInfoDto() {

    }

    // 생성자는 amNum을 받지 않도록 변경
    public AptInfoDto(Long amNum, String aptName, String aptDong, String aptHo) {
        this.amNum = amNum;
        this.aptName = aptName;
        this.aptDong = aptDong;
        this.aptHo = aptHo;
    }

    public static AptInfoDto fromAptEntity(AptEntity aptEntity) {
        AptInfoDto aptInfoDto = new AptInfoDto();
        aptInfoDto.setAmNum(aptEntity.getAmNum());
        aptInfoDto.setAptName(aptEntity.getAptName());
        aptInfoDto.setAptDong(aptEntity.getAptDong());
        aptInfoDto.setAptHo(aptEntity.getAptHo());
        return aptInfoDto;
    }


    public void setAmNum(Long amNum) {
        this.amNum = amNum;
    }
}

