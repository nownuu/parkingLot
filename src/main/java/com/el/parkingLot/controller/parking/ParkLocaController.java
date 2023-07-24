package com.el.parkingLot.controller.parking;

import com.el.parkingLot.dto.parking.ParkLocaDto;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.repository.parking.ParkLocaRepository;
import com.el.parkingLot.service.parking.ParkLocaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ParkLocaController {

    private final ParkLocaService parkLocaService;

    // 내 차량 주차장 정보 출력하기 - 로그인이 안되어있는 경우 login으로 리다이렉트
    @GetMapping("/parkingLot/parkLocaInfo")
    public String getParkLocaInfo(Model model, HttpSession session) {
        String loginCarNum = (String) session.getAttribute("loginCarNum");

        if (loginCarNum != null) {
            List<ParkLocaDto> parkLocaList = parkLocaService.findByParkLoca(loginCarNum);
            model.addAttribute("parkLocaInfoList", parkLocaList);
            return "parkLocaInfo"; // parkLocaInfo.html을 렌더링하는 뷰 이름 반환
        } else {
            // 로그인이 안 된 경우 로그인 페이지로 리다이렉트
            return "redirect:/parkingLot/login";
        }
    }
}



