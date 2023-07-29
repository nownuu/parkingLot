package com.el.parkingLot.controller.parking;

import com.el.parkingLot.entity.parking.ParkInfoEntity;
import com.el.parkingLot.entity.parking.ParkLocaEntity;
import com.el.parkingLot.service.parking.ParkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkInfoController {

    private final ParkInfoService parkInfoService;

    @Autowired
    public ParkInfoController(ParkInfoService parkInfoService) {
        this.parkInfoService = parkInfoService;
    }

    @GetMapping("/parkingLot/parkInfoLoca")
    public String getParkInfoWithParkLoca(Model model) {
        List<Object[]> result = parkInfoService.getParkInfoWithParkLoca();

        for (Object[] row : result) {
            ParkInfoEntity parkInfoEntity = (ParkInfoEntity) row[0];
            ParkLocaEntity parkLocaEntity = (ParkLocaEntity) row[1];

            System.out.println("ParkInfoEntity - pcInfo: " + parkInfoEntity.getPcInfo() + ", inCar: " + parkInfoEntity.getInCar());
            System.out.println("ParkLocaEntity - parkLocaId: " + parkLocaEntity.getParkLocaId() + ", location: " + parkLocaEntity.getLocation());
        }

        model.addAttribute("parkLocaInfoList", result);
        return "parkInfoLoca";
    }
}

