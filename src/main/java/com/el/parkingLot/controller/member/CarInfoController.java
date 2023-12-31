package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.repository.member.CarInfoRepository;
import com.el.parkingLot.service.member.CarInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mvc/parkingLot")
@RequiredArgsConstructor
public class CarInfoController {

    private final CarInfoService carInfoService;
    private final CarInfoRepository carInfoRepository;

    @GetMapping("/parkingLot/CarInfoSave")
    public String CarInfoForm() {
        return "CarInfoSave";
    }

    @PostMapping("/parkingLot/CarInfoSave")
    public String save(@ModelAttribute CarInfoDto carInfoDto, HttpSession session){
        CarInfoDto savedCarInfo = carInfoService.saveCarInfo(carInfoDto);

        session.setAttribute("carEntity", savedCarInfo);

        return "save"; //회원정보 입력 화면으로 -> 이후에 수정 가능
    }
    
    // 본인 차량 정보 출력하기 - 로그인이 안되어있는 경우 login으로 리다이엑트
    @GetMapping("/parkingLot/myCarInfo")
    public String getMyCarInfo(Model model, HttpSession session) {
        String loginCarNum = (String) session.getAttribute("loginCarNum");

        if (loginCarNum != null) {
            List<CarEntity> myCarInfoList = carInfoRepository.findByCarNum(loginCarNum);
            model.addAttribute("myCarInfoList", myCarInfoList);
            return "myCarInfo";
        } else {
            // 로그인이 안 된 경우 로그인 페이지로 리다이렉트
            return "redirect:/parkingLot/login";
        }
    }
}
