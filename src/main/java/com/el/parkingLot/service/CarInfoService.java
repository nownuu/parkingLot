package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.repository.member.CarInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarInfoService {

    private final CarInfoRepository carInfoRepository;

    @Autowired
    public CarInfoService(CarInfoRepository carInfoRepository){
        this.carInfoRepository = carInfoRepository;
    }

    @Transactional
    public CarInfoDto saveCarInfo(CarInfoDto carInfoDto){
        CarEntity carEntity = CarEntity.toCarEntity(carInfoDto);
        CarEntity savedCarEntity = carInfoRepository.save(carEntity);
        return CarInfoDto.fromCarEntity(savedCarEntity);
    }
}
