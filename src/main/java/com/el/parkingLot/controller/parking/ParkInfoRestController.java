package com.el.parkingLot.controller.parking;

import com.el.parkingLot.dto.parking.ParkInfoDto;
import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkInfoRepository;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import com.el.parkingLot.service.parking.ParkInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parkingLot")
@RequiredArgsConstructor
public class ParkInfoRestController {

    private final ParkInfoService parkInfoService;
    private final ParkInfoRepository parkInfoRepository;
    private final ParkLocaRepository parkLocaRepository;

    @GetMapping("/myParkingInfo")
    public ResponseEntity<List<ParkInfoDto>> getMyParkingInfo(HttpSession session) {
        String loginPhone = (String) session.getAttribute("loginPhone");

        if (loginPhone != null) {
            List<ParkInfoEntity> parkInfoList = parkInfoRepository.findByMember_MemberPhone(loginPhone);
            List<ParkInfoDto> parkInfoDtoList = parkInfoList.stream()
                    .map(ParkInfoDto::toParkInfoDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(parkInfoDtoList);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    
    // 관리자
    @GetMapping("/adminParkInfoLoca")
    public ResponseEntity<List<Object[]>> getParkInfoWithParkLoca() {
        List<Object[]> result = parkInfoService.getParkInfoWithParkLoca();
        return ResponseEntity.ok(result);
    }
}
