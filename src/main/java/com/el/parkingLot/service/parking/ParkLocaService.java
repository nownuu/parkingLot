package com.el.parkingLot.service.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.member.MemberRepository;
import com.el.parkingLot.repository.parking.ParkInfoRepository;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkLocaService {

    private final ParkLocaRepository parkLocaRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public ParkLocaService(ParkLocaRepository parkLocaRepository, MemberRepository memberRepository) {
        this.parkLocaRepository = parkLocaRepository;
        this.memberRepository = memberRepository;
    }

    // 본인 차량 주차장 정보 저장하기 (추후에 하드웨어팀에서 ?)
    @Transactional
    public ParkLocaDto saveParkLocaInfo(ParkLocaDto parkLocaDto) {
        ParkLocaEntity parkLocaEntity = ParkLocaEntity.toParkEntity(parkLocaDto);
        ParkLocaEntity savedParkLocaEntity = parkLocaRepository.save(parkLocaEntity);

        return ParkLocaDto.fromParkLocaEntity(savedParkLocaEntity);
    }
}
