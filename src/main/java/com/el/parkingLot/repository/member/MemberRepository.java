package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findByMemberPhone(String memberPhone);
    MemberEntity findByCarEntityCarNum(String carNum);
}