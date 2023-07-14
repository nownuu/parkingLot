package com.el.parkingLot.controller;

import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// 회원가입 컨트롤러
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/parkingLot/save")
    public String saveForm() {
        return "save";
    }


    @PostMapping("/parkingLot/save")
    public String save(@ModelAttribute MemberDto memberDto) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDto);
        memberService.save(memberDto);

        return "index"; //회원가입 완료시 화면으로 돌아가기 -> 이후에 수정 가능
        }
    }
