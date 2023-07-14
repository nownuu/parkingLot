package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.entity.member.AptEntity;
import com.el.parkingLot.repository.member.AptInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AptInfoService {

    private final AptInfoRepository aptInfoRepository;

    public void AptInfoSave(AptInfoDto aptInfoDto){
        AptEntity aptEntity = AptEntity.toAptEntity(aptInfoDto);
        aptInfoRepository.save(aptEntity);
    }
}
