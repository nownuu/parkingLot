package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.parking.ParkInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkInfoRepository  extends JpaRepository<ParkInfoEntity, Long> {
}
