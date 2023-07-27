package com.el.parkingLot.entity.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parkLoca")
public class ParkLocaEntity {
    @Id
    @Column(name = "pLocation")
    private String pLocation;

    @Column(name = "temp")
    private int temp;

    @Column(name = "gas")
    private String gas;

    @ManyToOne
    @JoinColumn(name = "parkInfo", referencedColumnName = "pcInfo")
    private ParkInfoEntity parkInfoEntity;


    public static ParkLocaDto toParkLocaDto(ParkLocaEntity parkLocaEntity) {
        ParkLocaDto parkLocaDto = new ParkLocaDto();
        parkLocaDto.setPLocation(parkLocaEntity.getPLocation());
        parkLocaDto.setTemp(parkLocaEntity.getTemp());
        parkLocaDto.setGas(parkLocaEntity.getGas());

        return parkLocaDto;
    }
}
