package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkLocaService {

    private final ParkLocaRepository parkLocaRepository;

    @Autowired
    public ParkLocaService(ParkLocaRepository parkLocaRepository) {
        this.parkLocaRepository = parkLocaRepository;
    }

    @Transactional
    public ParkLocaDto saveParkLocaInfo(ParkLocaDto parkLocaDto) {
        ParkLocaEntity parkLocaEntity = ParkLocaEntity.toParkEntity(parkLocaDto);
        ParkLocaEntity savedParkLocaEntity = parkLocaRepository.save(parkLocaEntity);

        return ParkLocaDto.fromParkLocaEntity(savedParkLocaEntity);
    }

    // 본인 차량 주차장 정보 보기
    @Transactional
    public List<ParkLocaDto> findByParkLoca(String carNum) {
        List<ParkLocaEntity> parkLocaList = parkLocaRepository.findByCarNum(carNum);

        if (!parkLocaList.isEmpty()) {
            return parkLocaList.stream()
                    .map(ParkLocaDto::fromParkLocaEntity)
                    .collect(Collectors.toList());
        } else {
            // 없는 경우 빈 리스트 반환
            return new ArrayList<>();
        }
    }
}
