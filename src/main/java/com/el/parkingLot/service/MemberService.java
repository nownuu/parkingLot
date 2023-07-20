package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
    }

    public MemberEntity login(String memberPhone, String carNum) {
        List<MemberEntity> memberList = memberRepository.findByMemberPhone(memberPhone);

        for (MemberEntity memberEntity : memberList) {
            CarEntity carEntity = memberEntity.getCarEntity();
            if (carEntity != null && carEntity.getCarNum().equals(carNum)) {
                // 자동차 정보와 일치하면 로그인 성공
                return memberEntity;
            }
        }

        return null;
    }
}
