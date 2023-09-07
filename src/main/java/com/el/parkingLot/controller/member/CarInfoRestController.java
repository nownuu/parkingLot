package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.repository.member.CarInfoRepository;
import com.el.parkingLot.service.member.CarInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkingLot")
@RequiredArgsConstructor
public class CarInfoRestController {

    private final CarInfoService carInfoService;
    private final CarInfoRepository carInfoRepository;

    @PostMapping("/save")
    public CarInfoDto saveCarInfo(@RequestBody CarInfoDto carInfoDto) {
        return carInfoService.saveCarInfo(carInfoDto);
    }

    // 본인 차량 정보 보기
    @GetMapping("/myInfo")
    public List<CarEntity> getMyCarInfo(@RequestParam String carNum) {
        // carNum을 사용하여 차량 정보 조회
        return carInfoRepository.findByCarNum(carNum);
    }
}
