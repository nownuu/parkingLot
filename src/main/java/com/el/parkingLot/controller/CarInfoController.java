package com.el.parkingLot.controller;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.service.CarInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarInfoController {

    private final CarInfoService carInfoService;

    @GetMapping("/parkingLot/CarInfoSave")
    public String CarInfoForm() {
        return "CarInfoSave";
    }

    @PostMapping("/parkingLot/CarInfoSave")
    public String save(@ModelAttribute CarInfoDto carInfoDto, HttpSession session){
        System.out.println("CarInfoController.save");
        System.out.println("CarInfoDTO = " + carInfoDto);

        CarInfoDto savedCarInfo = carInfoService.saveCarInfo(carInfoDto);

        session.setAttribute("carEntity", savedCarInfo);

        return "save"; //회원정보 입력 화면으로 -> 이후에 수정 가능
    }
    
    // 본인 차량 정보 출력하기 - 로그인이 안되어있는 경우 login으로 리다이엑트
    @GetMapping("/parkingLot/myCarInfo")
    public String getMyCarInfo(Model model, HttpSession session) {
        String loginPhone = (String) session.getAttribute("loginPhone");
        if (loginPhone != null) {
            List<CarInfoDto> myCarInfoList = carInfoService.getCarInfoByMemberPhone(loginPhone);
            model.addAttribute("myCarInfoList", myCarInfoList);
            return "myCarInfo";
        } else {
            // 로그인이 안 된 경우 로그인 페이지로 리다이렉트
            return "redirect:/parkingLot/login";
        }
    }

}
