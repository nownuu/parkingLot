package com.el.parkingLot.entity.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    public static ParkLocaEntity toParkEntity(ParkLocaDto parkLocaDto){
        ParkLocaEntity parkLocaEntity = new ParkLocaEntity();
        parkLocaEntity.setPLocation(parkLocaDto.getPLocation());
        parkLocaEntity.setTemp(parkLocaDto.getTemp());
        parkLocaEntity.setGas(parkLocaDto.getGas());

        return parkLocaEntity;
    }

    // 본인 차량 주차장 정보 보기

    @OneToMany(mappedBy = "parkLocaEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ParkInfoEntity> parkLocaEntityList;

    public List<ParkInfoEntity> getParking() {
        return parkLocaEntityList;
    }
}
