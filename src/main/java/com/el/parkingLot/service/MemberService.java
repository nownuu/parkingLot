// MemberService
package com.el.parkingLot.service;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(MemberDto memberDto) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
    }
}
