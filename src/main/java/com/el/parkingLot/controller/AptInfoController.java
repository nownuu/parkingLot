package com.el.parkingLot.controller;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.service.AptInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AptInfoController {

    private final AptInfoService aptInfoService;

    @GetMapping("/parkingLot/AptInfoSave")
    public String AptInfoForm(){
        return "AptInfoSave";
    }

    @PostMapping("/parkingLot/AptInfoSave")
    public String save(@ModelAttribute AptInfoDto aptInfoDto){
        System.out.println("AptInfoController.save");
        System.out.println("AptInfoDTO = " + aptInfoDto);
        aptInfoService.AptInfoSave(aptInfoDto);
        return "CarInfoSave"; //차량번호 입력 -> 이후에 수정 가능
    }
}
