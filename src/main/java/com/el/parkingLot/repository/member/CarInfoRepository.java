
package com.el.parkingLot.repository.member;

        import com.el.parkingLot.entity.member.CarEntity;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface CarInfoRepository extends JpaRepository<CarEntity, Long> {

}

