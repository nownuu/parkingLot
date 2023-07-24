package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkInfoRepository;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParkInfoService {

    private final ParkInfoRepository parkInfoRepository;
    private final ParkLocaRepository parkLocaRepository; // ParkLocaRepository 주입

    @Transactional
    public void saveParkInfo(ParkInfoDto parkInfoDto) {
        ParkInfoEntity parkInfoEntity = ParkInfoEntity.toParkInfoEntity(parkInfoDto);
        ParkLocaEntity parkLocaEntity = ParkLocaEntity.toParkEntity(parkInfoDto.getParkLocaDto());

        parkInfoEntity.setParkLocaEntity(parkLocaEntity);

        parkInfoRepository.save(parkInfoEntity);
    }
}

