package com.springboot.study.controller;

import com.springboot.study.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
    @GetMapping("/restLogin")
    public String resetLogin() {
        return "restLogin"; //로그인 화면, view name --> templates
    }

    /**
     * Spring Legacy 버전 (3.0 이하) --> ModelAndView 객체를 활용하여 데이터 및 view 전송
     */
//    @PostMapping("/login")
//    public ModelAndView login(@RequestParam String id, @RequestParam String pass) {
//        ModelAndView model = new ModelAndView();
//        String result="";
//        if (id.equals("test") && pass.equals("1234"))  result = "[ModelAndView]로그인 성공";
//        else result = "[ModelAndView]로그인 실패";
//
//        model.addObject("result", result);
//        model.setViewName("loginResult");
//        return model;
//    }


    @PostMapping("/login")
    public String login(Member member
                        , Model model) {
        String result="";
        if (member.getId().equals("test") && member.getPass().equals("1234")) {
            result = "로그인 성공";
        } else {
            result = "로그인 실패";
        }

        model.addAttribute("result", result);

        return "loginResult";
    }

    @GetMapping("/restSignup")
    public String restSignup() {
        return "restSignup"; //회원가입 화면, view name --> templates
    }

    @PostMapping("/signup")
    public String signup(Member member, Model model) {
        System.out.println("id: "+member.getId());
        System.out.println("password: "+member.getPass());
        System.out.println("name: "+member.getName());
        System.out.println("address: "+member.getAddress());
        model.addAttribute("member", member);
        return "signupResult"; //회원가입 화면, view name --> templates
    }
}



