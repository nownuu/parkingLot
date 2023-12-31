package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.member.AptEntity;
import com.el.parkingLot.entity.member.CarEntity;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mvc/parkingLot")
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

            // 차량 번호도 세션에 저장하기
            String carNumSession = loggedInMember.getCarEntity().getCarNum();
            session.setAttribute("loginCarNum", carNumSession);

            return "loginSuccess";
        } else {
            // 로그인 실패
            return "login";
        }
    }

    // 로그아웃 구현
    @GetMapping("/parkingLot/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }


    // 회원 목록 출력하기 -- 관리자 만들 때
    @GetMapping("/parkingLot/adminMember")
    public String getMemberInfo(Model model) {
        List<Object[]> result = memberService.getMemberInfo();
        model.addAttribute("memberList", result);
        return "adminMember";
    }
}

