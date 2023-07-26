package com.el.parkingLot.controller.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.service.parking.ParkInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkInfo")
@RequiredArgsConstructor
public class ParkInfoController {

    private final ParkInfoService parkInfoService;

    // 주차 관련 정보 조회하기
    @GetMapping("/{pcInfo}")
    public ResponseEntity<ParkInfoDto> getParkInfo(@PathVariable Long pcInfo) {
        ParkInfoDto parkInfoDto = parkInfoService.getParkInfo(pcInfo);
        return ResponseEntity.ok(parkInfoDto);
    }

    // 관리자 모든 주차 관련 정보 조회하기
    @GetMapping
    public ResponseEntity<List<ParkInfoDto>> getAllParkInfo() {
        List<ParkInfoDto> parkInfoList = parkInfoService.getAllParkInfo();
        return ResponseEntity.ok(parkInfoList);
    }

    // 주차 관련 정보 저장하기
    @PostMapping
    public ResponseEntity<Void> saveParkInfo(@RequestBody ParkInfoDto parkInfoDto) {
        parkInfoService.saveParkInfo(parkInfoDto);
        return ResponseEntity.ok().build();
    }

    // 본인 차량 주차장 정보 조회하기
    @GetMapping("/parkLocaInfo/{carNum}")
    public ResponseEntity<List<ParkLocaDto>> getMyParkingInfo(@PathVariable String carNum) {
        List<ParkLocaDto> parkLocaList = parkInfoService.getParkLocaInfo(carNum);
        return ResponseEntity.ok(parkLocaList);
    }
}

