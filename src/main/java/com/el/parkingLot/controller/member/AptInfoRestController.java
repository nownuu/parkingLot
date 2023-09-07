package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.service.member.AptInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parkingLot")
@RequiredArgsConstructor
public class AptInfoRestController {

    private final AptInfoService aptInfoService;

    @PostMapping("/AptInfoSave")
    public AptInfoDto save(@RequestBody AptInfoDto aptInfoDto) {
        // 아파트 정보를 데이터베이스에 저장하고 결과를 반환
        return aptInfoService.saveAptInfo(aptInfoDto);
    }
}
