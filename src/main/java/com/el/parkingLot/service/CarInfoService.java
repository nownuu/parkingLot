package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.repository.member.CarInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarInfoService {

    private final CarInfoRepository carInfoRepository;

    public void CarInfoSave(CarInfoDto carInfoDto){
        CarEntity carEntity = CarEntity.toCarEntity(carInfoDto);
        carInfoRepository.save(carEntity);
    }
}
