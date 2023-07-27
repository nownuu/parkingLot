package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkLocaService {
    private final ParkLocaRepository parkLocaRepository;

    @Autowired
    public ParkLocaService(ParkLocaRepository parkLocaRepository) {
        this.parkLocaRepository = parkLocaRepository;
    }

    public List<ParkLocaEntity> getParkLocaByCarNum(String carNum) {
        return parkLocaRepository.findByCarNum(carNum);
    }
}

