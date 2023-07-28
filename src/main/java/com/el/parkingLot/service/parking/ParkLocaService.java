package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkLocaService {

    private final ParkLocaRepository parkLocaRepository;

    @Autowired
    public ParkLocaService(ParkLocaRepository parkLocaRepository) {
        this.parkLocaRepository = parkLocaRepository;
    }

//    @Transactional
//    public ParkLocaDto saveParkLoca(ParkLocaDto parkLocaDto) {
//        // 추후에 저장 로직
//    }

    @Transactional(readOnly = true)
    public ParkLocaDto getParkLoca(Long parkLocaId) {
        ParkLocaEntity parkLocaEntity = parkLocaRepository.findById(parkLocaId).orElse(null);
        return (parkLocaEntity != null) ? ParkLocaDto.toParkLocaDto(parkLocaEntity) : null;
    }
}

