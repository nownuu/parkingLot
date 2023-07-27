package com.el.parkingLot.service.parking;

        import com.el.parkingLot.dto.parking.ParkInfoDto;
        import com.el.parkingLot.dto.parking.ParkLocaDto;
        import com.el.parkingLot.entity.parking.ParkInfoEntity;
        import com.el.parkingLot.entity.parking.ParkLocaEntity;
        import com.el.parkingLot.repository.parking.ParkInfoRepository;
        import com.el.parkingLot.repository.parking.ParkLocaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.stream.Collectors;

@Service
public class ParkInfoService {

    private final ParkInfoRepository parkInfoRepository;
    private final ParkLocaRepository parkLocaRepository;

    @Autowired
    public ParkInfoService(ParkInfoRepository parkInfoRepository, ParkLocaRepository parkLocaRepository) {
        this.parkInfoRepository = parkInfoRepository;
        this.parkLocaRepository = parkLocaRepository;
    }

    public List<ParkInfoEntity> getParkInfoByCarNum(String carNum) {
        return parkInfoRepository.findByCarNum(carNum);
    }
}
