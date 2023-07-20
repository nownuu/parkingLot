package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apt_info")
public class AptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amNum")
    private Long amNum;

    @Column(name = "apt_name")
    private String aptName;

    @Column(name = "apt_dong")
    private String aptDong;

    @Column(name = "apt_ho")
    private String aptHo;

    public static AptEntity toAptEntity(AptInfoDto aptInfoDto) {
        AptEntity aptEntity = new AptEntity();
        aptEntity.setAptName(aptInfoDto.getAptName());
        aptEntity.setAptDong(aptInfoDto.getAptDong());
        aptEntity.setAptHo(aptInfoDto.getAptHo());
        return aptEntity;
    }
}
