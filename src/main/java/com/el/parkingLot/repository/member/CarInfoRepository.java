package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CarInfoRepository {

    private final EntityManager entityManager;

    @Autowired
    public CarInfoRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public CarEntity save(CarEntity carEntity){
        entityManager.persist(carEntity);
        return carEntity;
    }
}
