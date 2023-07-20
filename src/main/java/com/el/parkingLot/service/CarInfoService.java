package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.repository.member.CarInfoRepository;
import com.el.parkingLot.repository.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarInfoService {

    private final CarInfoRepository carInfoRepository;
    private final MemberRepository memberRepository;
    @Autowired
    public CarInfoService(CarInfoRepository carInfoRepository, MemberRepository memberRepository){
        this.carInfoRepository = carInfoRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public CarInfoDto saveCarInfo(CarInfoDto carInfoDto){
        CarEntity carEntity = CarEntity.toCarEntity(carInfoDto);
        CarEntity savedCarEntity = carInfoRepository.save(carEntity);
        return CarInfoDto.fromCarEntity(savedCarEntity);
    }

    
    // 본인 차량 정보 보기
    public List<CarInfoDto> getCarInfoByMemberPhone(String memberPhone) {
        List<MemberEntity> memberList = memberRepository.findByMemberPhone(memberPhone);

        if (!memberList.isEmpty()) {
            MemberEntity memberEntity = memberList.get(0); // Assuming the first member is the correct one
            List<CarEntity> carEntityList = memberEntity.getCarEntities();
            return carEntityList.stream()
                    .map(CarInfoDto::fromCarEntity)
                    .collect(Collectors.toList());
        } else {
            // Handle case when member is not found
            return new ArrayList<>();
        }
    }
}
