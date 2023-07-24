package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.parking.ParkInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkInfoRepository extends JpaRepository<ParkInfoEntity, Long> {
    List<ParkInfoEntity> findByCarNum(String loginCarNum);
}
