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
@Table(name = "parkLoca_info")
public class ParkLocaEntity {
    @Id
    @Column(name = "pLocation")
    private String pLocation;

    @Column(name = "temp")
    private int temp;

    @Column(name = "gas")
    private String gas;

    @OneToOne
    @JoinColumn(name = "parkInfo", referencedColumnName = "pcInfo")
    private ParkInfoEntity parkInfoEntity;

    public static ParkLocaEntity toParkEntity(ParkLocaDto parkLocaDto) {
        ParkLocaEntity parkLocaEntity = new ParkLocaEntity();
        parkLocaEntity.setPLocation(parkLocaDto.getPLocation());
        parkLocaEntity.setTemp(parkLocaDto.getTemp());
        parkLocaEntity.setGas(parkLocaDto.getGas());

        return parkLocaEntity;
    }
}
