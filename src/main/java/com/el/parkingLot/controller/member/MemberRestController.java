package com.el.parkingLot.controller.member;

import com.el.parkingLot.dto.member.AptInfoDto;
import com.el.parkingLot.dto.member.CarInfoDto;
import com.el.parkingLot.dto.member.MemberDto;
import com.el.parkingLot.entity.member.MemberEntity;
import com.el.parkingLot.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/parkingLot")
@RequiredArgsConstructor
@SessionAttributes({"aptInfoDto", "carInfoDto"})
public class MemberRestController {

    private final MemberService memberService;

    @ModelAttribute("aptInfoDto")
    public AptInfoDto createAptInfoDto() {
        return new AptInfoDto();
    }

    @ModelAttribute("carInfoDto")
    public CarInfoDto createCarInfoDto() {
        return new CarInfoDto();
    }

    @GetMapping("/save")
    public String memberForm() {
        return "save";
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody MemberDto memberDto) {
        AptInfoDto aptInfoDto = memberDto.getAptInfoDto();
        CarInfoDto carInfoDto = memberDto.getCarInfoDto();

        memberService.saveMember(memberDto);

        return ResponseEntity.ok("회원 가입 성공");
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String memberPhone, @RequestParam String carNum, HttpSession session) {
        MemberEntity loggedInMember = memberService.login(memberPhone, carNum);

        if (loggedInMember != null) {
            session.setAttribute("loginPhone", loggedInMember.getMemberPhone());
            String carNumSession = loggedInMember.getCarEntity().getCarNum();
            session.setAttribute("loginCarNum", carNumSession);
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }

    
    // 관리자
    @GetMapping("/adminMember")
    public ResponseEntity<List<Object[]>> getMemberInfo() {
        List<Object[]> result = memberService.getMemberInfo();
        return ResponseEntity.ok(result);
    }
}
