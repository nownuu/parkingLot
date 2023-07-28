package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.repository.parking.ParkInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkInfoService {

    private final ParkInfoRepository parkInfoRepository;

    @Autowired
    public ParkInfoService(ParkInfoRepository parkInfoRepository) {
        this.parkInfoRepository = parkInfoRepository;
    }

//    @Transactional
//    public ParkInfoDto saveParkInfo(ParkInfoDto parkInfoDto) {
//        // 추후에 저장 로직
//    }

    @Transactional(readOnly = true)
    public ParkInfoDto getParkInfo(Long pcInfoId) {
        ParkInfoEntity parkInfoEntity = parkInfoRepository.findById(pcInfoId).orElse(null);
        return (parkInfoEntity != null) ? ParkInfoDto.toParkInfoDto(parkInfoEntity) : null;
    }
}
