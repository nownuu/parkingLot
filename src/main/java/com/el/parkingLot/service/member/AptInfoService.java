package com.el.parkingLot.service.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.entity.member.AptEntity;
import com.el.parkingLot.repository.member.AptInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AptInfoService {

    private final AptInfoRepository aptInfoRepository;

    @Autowired
    public AptInfoService(AptInfoRepository aptInfoRepository) {
        this.aptInfoRepository = aptInfoRepository;
    }

    @Transactional
    public AptInfoDto saveAptInfo(AptInfoDto aptInfoDto) {
        AptEntity aptEntity = AptEntity.toAptEntity(aptInfoDto);
        AptEntity savedAptEntity = aptInfoRepository.save(aptEntity);
        return AptInfoDto.fromAptEntity(savedAptEntity);
    }
}
