package com.el.parkingLot.controller.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.service.parking.ParkInfoService;
import com.el.parkingLot.service.parking.ParkLocaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/park-info")
@RequiredArgsConstructor
public class ParkInfoController {

    private final ParkInfoService parkInfoService;
    private final ParkLocaService parkLocaService;

    @PostMapping
    public ResponseEntity<Void> saveParkInfo(@RequestBody ParkInfoDto parkInfoDto) {
        parkInfoService.saveParkInfo(parkInfoDto);
        return ResponseEntity.ok().build();
    }

    // 내 차량 주차장 정보 보기
    @GetMapping("/parkingLot/parkLocaInfo/{carNum}") // 경로 변수로 지정
    public ResponseEntity<List<ParkLocaDto>> getMyParkingInfo(@PathVariable String carNum) {
        List<ParkLocaDto> parkLocaList = parkLocaService.findByParkLoca(carNum);
        return ResponseEntity.ok(parkLocaList);
    }
}
