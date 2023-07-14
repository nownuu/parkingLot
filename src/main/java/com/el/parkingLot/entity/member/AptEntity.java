package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "aptInfo_table")
public class AptEntity {
    @Id
    private Long amNum;

    @Column
    private String aptName;

    @Column
    private String aptDong;

    @Column
    private String aptHo;

    public static AptEntity toAptEntity(AptInfoDto aptInfoDto){
        AptEntity aptEntity = new AptEntity();
        aptEntity.setAmNum(aptInfoDto.getAmNum());
        aptEntity.setAptName(aptInfoDto.getAptName());
        aptEntity.setAptDong(aptInfoDto.getAptDong());
        aptEntity.setAptHo(aptInfoDto.getAptHo());
        return aptEntity;
    }
}
