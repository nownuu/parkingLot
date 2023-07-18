package com.el.parkingLot.controller;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.service.CarInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CarInfoController {

    private final CarInfoService carInfoService;

    @GetMapping("/parkingLot/CarInfoSave")
    public String CarInfoForm() {
        return "CarInfoSave";
    }

    @PostMapping("/parkingLot/CarInfoSave")
    public String save(@ModelAttribute CarInfoDto carInfoDto){
        System.out.println("CarInfoController.save");
        System.out.println("CarInfoDTO = " + carInfoDto);
        carInfoService.CarInfoSave(carInfoDto);
        return "save"; //회원정보 입력 화면으로 -> 이후에 수정 가능
    }
}
