package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.service.member.AptInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AptInfoController {

    private final AptInfoService aptInfoService;

    @GetMapping("/parkingLot/AptInfoSave")
    public String aptInfoForm() {
        return "AptInfoSave"; // "AptInfoSave"는 입력 폼을 보여주는 View의 이름입니다.
    }

    @PostMapping("/parkingLot/AptInfoSave")
    public String save(@ModelAttribute AptInfoDto aptInfoDto, HttpSession session) {
        System.out.println("AptInfoController.save");
        System.out.println("AptInfoDTO = " + aptInfoDto);

        // 아파트 정보를 데이터베이스에 저장
        AptInfoDto savedAptInfo = aptInfoService.saveAptInfo(aptInfoDto);

        // 세션에 저장된 아파트 정보를 갱신
        session.setAttribute("aptEntity", savedAptInfo);

        return "redirect:/parkingLot/CarInfoSave"; // 차량정보 입력 화면으로 이동
    }
}
