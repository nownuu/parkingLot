package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.AptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptInfoRepository extends JpaRepository<AptEntity, Long> {

}

