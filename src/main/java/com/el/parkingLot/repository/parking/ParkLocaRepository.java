package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.parking.ParkLocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkLocaRepository extends JpaRepository<ParkLocaEntity, String> {
}
