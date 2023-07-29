package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.parking.ParkLocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkLocaRepository extends JpaRepository<ParkLocaEntity, Long> {

}
