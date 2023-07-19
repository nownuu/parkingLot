package com.el.parkingLot.dto.member;

import com.el.parkingLot.entity.member.AptEntity;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
public class AptInfoDto {
    private String aptName;
    private String aptDong;
    private String aptHo;

    public AptInfoDto() {
    }

    public AptInfoDto(String aptName, String aptDong, String aptHo) {
        this.aptName = aptName;
        this.aptDong = aptDong;
        this.aptHo = aptHo;
    }
}
