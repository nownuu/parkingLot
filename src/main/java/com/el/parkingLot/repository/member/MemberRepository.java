package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findByMemberPhone(String memberPhone);

    @Query("SELECT m, c, a FROM MemberEntity m " +
            "LEFT JOIN FETCH m.carEntity c " +
            "LEFT JOIN FETCH m.aptEntity a")
    List<Object[]> findAllWithCarAndApt();
}