package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.AptEntity;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
public class AptInfoDto {
    private long amNum;
    private String aptName;
    private String aptDong;
    private String aptHo;

    public AptInfoDto() {
    }

    public AptInfoDto(Long amNum, String aptName, String aptDong, String aptHo) {
        this.amNum = amNum;
        this.aptName = aptName;
        this.aptDong = aptDong;
        this.aptHo = aptHo;
    }

    public static AptInfoDto fromAptEntity(AptEntity aptEntity) {
        return new AptInfoDto(aptEntity.getAmNum(), aptEntity.getAptName(), aptEntity.getAptDong(), aptEntity.getAptHo());
    }

    public long getAmNum() {
        return amNum;
    }
}

