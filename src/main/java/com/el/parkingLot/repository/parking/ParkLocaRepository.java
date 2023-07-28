package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.parking.ParkLocaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkLocaRepository extends JpaRepository<ParkLocaEntity, Long> {
    // 원하는 커스텀 쿼리 메서드가 있으면 추가합니다.
}
