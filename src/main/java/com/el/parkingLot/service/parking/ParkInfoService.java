package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkInfoService {
    private final ParkInfoRepository parkInfoRepository;

    public ParkInfoService(ParkInfoRepository parkInfoRepository) {
        this.parkInfoRepository = parkInfoRepository;
    }

    public ParkInfoDto getParkInfo(Long pcInfo) {
        ParkInfoEntity parkInfoEntity = parkInfoRepository.findById(pcInfo)
                .orElseThrow(() -> new RuntimeException("ParkInfo not found for id: " + pcInfo));

        return ParkInfoDto.toParkInfoDto(parkInfoEntity);
    }

    public void saveParkInfo(ParkInfoDto parkInfoDto) {
        ParkInfoEntity parkInfoEntity = ParkInfoEntity.toParkInfoEntity(parkInfoDto);
        parkInfoRepository.save(parkInfoEntity);
    }

    public List<ParkInfoDto> getAllParkInfo() {
        List<ParkInfoEntity> parkInfoEntities = parkInfoRepository.findAll();
        return parkInfoEntities.stream()
                .map(ParkInfoDto::toParkInfoDto)
                .collect(Collectors.toList());
    }

    public List<ParkLocaDto> getParkLocaInfo(String carNum) {
        List<ParkLocaEntity> parkLocaEntities = parkInfoRepository.findParkLocaInfoByCarNum(carNum);
        return parkLocaEntities.stream()
                .map(ParkLocaEntity::toParkLocaDto)
                .collect(Collectors.toList());
    }
}
