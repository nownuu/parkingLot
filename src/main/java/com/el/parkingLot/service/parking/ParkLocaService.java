package com.el.parkingLot.service.parking;

import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkLocaService {
    private final ParkLocaRepository parkLocaRepository;

    public ParkLocaService(ParkLocaRepository parkLocaRepository) {
        this.parkLocaRepository = parkLocaRepository;
    }
}

