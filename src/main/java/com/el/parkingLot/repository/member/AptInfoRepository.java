package com.el.parkingLot.repository.member;

import com.el.parkingLot.entity.member.AptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AptInfoRepository {
    private final EntityManager entityManager;

    @Autowired
    public AptInfoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AptEntity save(AptEntity aptEntity) {
        entityManager.persist(aptEntity);
        return aptEntity;
    }
}

