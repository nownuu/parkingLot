package com.el.parkingLot.controller;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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

}

