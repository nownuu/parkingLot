package com.el.parkingLot.repository.parking;

import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkInfoRepository extends JpaRepository<ParkInfoEntity, Long> {
    ParkInfoEntity findByParkLoca(MemberEntity memberEntity, String carNum);
}
