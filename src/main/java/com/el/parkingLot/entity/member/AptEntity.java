package com.el.parkingLot.entity.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "aptInfo")
public class AptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amNum")
    private Long amNum;

    @Column
    private String aptName;

    @Column
    private String aptDong;

    @Column
    private String aptHo;

    public static AptEntity toAptEntity(AptInfoDto aptInfoDto) {
        AptEntity aptEntity = new AptEntity();
        aptEntity.setAptName(aptInfoDto.getAptName());
        aptEntity.setAptDong(aptInfoDto.getAptDong());
        aptEntity.setAptHo(aptInfoDto.getAptHo());

        return aptEntity;
    }
}
