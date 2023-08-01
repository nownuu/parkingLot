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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParkInfoController {

    private final ParkInfoService parkInfoService;
    private final ParkInfoRepository parkInfoRepository;
    private final ParkLocaRepository parkLocaRepository;

    @Autowired
    public ParkInfoController(ParkInfoService parkInfoService, ParkInfoRepository parkInfoRepository, ParkLocaRepository parkLocaRepository) {
        this.parkInfoService = parkInfoService;
        this.parkInfoRepository = parkInfoRepository;
        this.parkLocaRepository = parkLocaRepository;
    }

    //본인의 차량 정보 보기
    @GetMapping("/parkingLot/myParkingInfo")
    public String getMyParkingInfo(Model model, HttpSession session) {
        String loginPhone = (String) session.getAttribute("loginPhone");

        if (loginPhone != null) {
            // 회원 번호에 해당하는 parkInfo 검색
            List<ParkInfoEntity> parkInfoList = parkInfoRepository.findByMember_MemberPhone(loginPhone);
            List<ParkInfoDto> parkInfoDtoList = parkInfoList.stream()
                    .map(ParkInfoDto::toParkInfoDto)
                    .collect(Collectors.toList());

            // parkInfo에 해당하는 parkLoca 검색
            List<ParkLocaDto> parkLocaDtoList = new ArrayList<>();
            for (ParkInfoEntity parkInfoEntity : parkInfoList) {
                ParkLocaEntity parkLocaEntity = parkInfoEntity.getParkLocaEntity();
                if (parkLocaEntity != null) {
                    ParkLocaDto parkLocaDto = ParkLocaDto.toParkLocaDto(parkLocaEntity);
                    parkLocaDtoList.add(parkLocaDto);
                }
            }

            model.addAttribute("parkInfoDtoList", parkInfoDtoList);
            model.addAttribute("parkLocaDtoList", parkLocaDtoList);

            return "myParkingInfo";
        } else {
            // 사용자가 로그인되어 있지 않으면 로그인 페이지로 리디렉션
            return "redirect:/parkingLot/login";
        }
    }



    // 전체 차량 정보 보기
    @GetMapping("/parkingLot/adminParkInfoLoca")
    public String getParkInfoWithParkLoca(Model model) {
        List<Object[]> result = parkInfoService.getParkInfoWithParkLoca();

        for (Object[] row : result) {
            ParkInfoEntity parkInfoEntity = (ParkInfoEntity) row[0];
            ParkLocaEntity parkLocaEntity = (ParkLocaEntity) row[1];

            System.out.println("ParkInfoEntity - pcInfo: " + parkInfoEntity.getPcInfo() + ", inCar: " + parkInfoEntity.getInCar());
            System.out.println("ParkLocaEntity - parkLocaId: " + parkLocaEntity.getParkLocaId() + ", location: " + parkLocaEntity.getLocation());
        }

        model.addAttribute("parkLocaInfoList", result);
        return "adminParkInfoLoca";
    }
}

