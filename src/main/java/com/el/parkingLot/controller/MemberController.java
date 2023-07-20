package com.el.parkingLot.controller;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"aptInfoDto", "carInfoDto"})
public class MemberController {

    private final MemberService memberService;

    @ModelAttribute("aptInfoDto")
    public AptInfoDto createAptInfoDto() {
        return new AptInfoDto();
    }

    @ModelAttribute("carInfoDto")
    public CarInfoDto createCarInfoDto() {
        return new CarInfoDto();
    }


    // 회원 가입 구현
    @GetMapping("/parkingLot/save")
    public String memberForm() {
        return "save";
    }

    @PostMapping("/parkingLot/save")
    public String save(@ModelAttribute MemberDto memberDto) {
        System.out.println("MemberController.save");
        System.out.println("MemberDTO = " + memberDto);

        AptInfoDto aptInfoDto = memberDto.getAptInfoDto();
        CarInfoDto carInfoDto = memberDto.getCarInfoDto();

        System.out.println("AptInfoDTO = " + aptInfoDto);
        System.out.println("CarInfoDTO = " + carInfoDto);

        memberService.saveMember(memberDto);

        return "index"; // 회원가입 성공시 메인 화면으로 -> 이후 수정 가능
    }

    // 로그인 구현
    @GetMapping("/parkingLot/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/parkingLot/login")
    public String login(@RequestParam String memberPhone, @RequestParam String carNum, HttpSession session) {
        MemberEntity loggedInMember = memberService.login(memberPhone, carNum);

        if (loggedInMember != null) {
            // 로그인 성공 시, memberPhone 값을 세션에 저장
            session.setAttribute("loginPhone", loggedInMember.getMemberPhone());
            return "loginSuccess";
        } else {
            // 로그인 실패
            return "login";
        }
    }

}

