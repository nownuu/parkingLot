package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarInfoRepository extends JpaRepository<CarEntity, Long> {
        Optional<CarEntity> findByMember_MemberPhone(String memberPhone);
}
