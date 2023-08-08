package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.repository.member.CarInfoRepository;
import com.el.parkingLot.service.member.CarInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/parkingLot")
@RequiredArgsConstructor
public class CarInfoRestController {

    private final CarInfoService carInfoService;
    private final CarInfoRepository carInfoRepository;

    @PostMapping("/carInfoSave")
    public CarInfoDto saveCarInfo(@RequestBody CarInfoDto carInfoDto, HttpSession session) {
        CarInfoDto savedCarInfo = carInfoService.saveCarInfo(carInfoDto);
        session.setAttribute("carEntity", savedCarInfo);
        return savedCarInfo;
    }

    // 본인 차량 정보 보기
    @GetMapping("/myCarInfo")
    public List<CarEntity> getMyCarInfo(HttpSession session) {
        String loginCarNum = (String) session.getAttribute("loginCarNum");
        if (loginCarNum != null) {
            return carInfoRepository.findByCarNum(loginCarNum);
        } else {
            // 에러 시...
            return null;
        }
    }
}
