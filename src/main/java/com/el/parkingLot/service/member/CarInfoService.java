package com.el.parkingLot.service.member;

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
    public CarInfoService(CarInfoRepository carInfoRepository, MemberRepository memberRepository) {
        this.carInfoRepository = carInfoRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public CarInfoDto saveCarInfo(CarInfoDto carInfoDto){
        CarEntity carEntity = CarEntity.toCarEntity(carInfoDto);
        CarEntity savedCarEntity = carInfoRepository.save(carEntity);
        return CarInfoDto.fromCarEntity(savedCarEntity);
    }


    @Transactional
    // 본인 차량 정보 보기
    public List<CarInfoDto> findByCarNum(String memberPhone) {
        List<MemberEntity> memberList = memberRepository.findByMemberPhone(memberPhone);

        if (!memberList.isEmpty()) {
            MemberEntity memberEntity = memberList.get(0);
            List<CarEntity> carEntityList = memberEntity.getCars();
            return carEntityList.stream()
                    .map(CarInfoDto::fromCarEntity)
                    .collect(Collectors.toList());
        } else {
            // 회원 정보가 없을 경우 빈 리스트 반환
            return new ArrayList<>();
        }
    }
}
