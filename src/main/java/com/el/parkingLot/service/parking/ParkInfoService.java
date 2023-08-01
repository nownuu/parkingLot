package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkInfoService {

    private final ParkInfoRepository parkInfoRepository;
    private final EntityManager entityManager;

    @Autowired
    public ParkInfoService(ParkInfoRepository parkInfoRepository, EntityManager entityManager) {
        this.parkInfoRepository = parkInfoRepository;
        this.entityManager = entityManager;
    }


//    public ParkInfoDto saveParkInfo(ParkInfoDto parkInfoDto) {
//        // 추후에 저장 로직
//    }

    //전체 차량 정보 보기
    @Transactional
    public List<Object[]> getParkInfoWithParkLoca() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<ParkInfoEntity> parkInfoRoot = query.from(ParkInfoEntity.class);
        Join<ParkInfoEntity, ParkLocaEntity> parkLocaJoin = parkInfoRoot.join("parkLocaEntity");

        query.select(criteriaBuilder.array(parkInfoRoot, parkLocaJoin));

        List<Object[]> result = entityManager.createQuery(query).getResultList();
        return result;
    }



}
