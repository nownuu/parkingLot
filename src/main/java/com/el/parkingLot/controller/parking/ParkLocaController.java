package com.el.parkingLot.controller.parking;

import com.el.parkingLot.service.parking.ParkLocaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ParkLocaController {

    private final ParkLocaService parkLocaService;

}

