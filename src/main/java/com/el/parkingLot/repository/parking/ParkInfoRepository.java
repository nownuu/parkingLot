package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParkInfoRepository extends JpaRepository<ParkInfoEntity, Long> {

    List<ParkInfoEntity> findByCarNum(String loginCarNum);
}
