package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInfoRepository extends JpaRepository<CarEntity, Long> {
}
