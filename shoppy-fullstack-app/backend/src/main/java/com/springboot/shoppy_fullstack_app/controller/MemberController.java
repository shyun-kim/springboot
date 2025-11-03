package com.springboot.shoppy_fullstack_app.controller;

import com.springboot.shoppy_fullstack_app.dto.Member;
import com.springboot.shoppy_fullstack_app.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/member")
//@CrossOrigin(origins = {"http://localhost:3000"})
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/idcheck")
    public String idcheck(@RequestBody Member member) {
        boolean result = memberService.idCheck(member.getId());  //아이디 O: 1, X: 0
        String msg = "";
        if(result) msg = "이미 사용중인 아이디 입니다.";
        else msg = "사용이 가능한 아이디 입니다.";
        return msg;
    }

    @PostMapping("/signup")
    public boolean signup(@RequestBody Member member) {
        boolean result = false;
        int rows = memberService.signup(member);
        if(rows == 1) result = true;
        return result;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Member member, HttpServletRequest request) {
        ResponseEntity<?> response = null;
        boolean result = memberService.login(member);

        if(result) {
            //세션 생성 - true, 빈값은 생성 파라미터
            //기존 세션 가져오기 - false
            HttpSession session = request.getSession(true);
            session.setAttribute("sid", "hong");
            //response 객체의 전송되는 쿠키에 세션 객체는 자동으로 담김
            response = ResponseEntity.ok(Map.of("login", true));
        } else {
            response = ResponseEntity.ok(Map.of("login", false));
        }


        return response;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String ssid = session.getId();
        String sid = (String)session.getAttribute("sid");
//        ResponseEntity<?> response = null;

        if(ssid != null && sid != null) {
            session.invalidate(); //세션 삭제 - 스프링의 세션테이블에서 삭제됨
            System.out.println("Session Object has been deleted");

            var cookie = new Cookie("JSESSIONID", null);
            cookie.setPath("/"); //기존과 동일
            cookie.setMaxAge(0); //즉시 만료
            cookie.setHttpOnly(true); // 개발중에도 http Only 유지 권장
//            cookie.setSecure(true); //Https에서만, 로컬 http면 주석
//            cookie.setDomain("localhost"); //기존쿠키가 domain=localhost 였다면 지정

            response.addCookie(cookie);


        }


        return ResponseEntity.ok(true);
    }

}
