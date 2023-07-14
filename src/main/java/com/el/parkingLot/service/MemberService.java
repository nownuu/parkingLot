package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository; // 먼저 jpa, mysql dependency 추가

    public void save(MemberDto memberDto) {
        // repsitory의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
        //Repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)

    }
}
