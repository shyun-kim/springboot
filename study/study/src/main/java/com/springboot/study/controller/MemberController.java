package com.springboot.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    @GetMapping("/login")
    public String login() {
        return "login"; //로그인 화면, view name --> templates
    }

    @PostMapping("/login")
    public String login(@RequestParam String id,
                        @RequestParam String pass,
                        Model model) {
        String result="";
        if (id.equals("test") && pass.equals("1234")) {
            result = "로그인 성공";
        } else {
            result = "로그인 실패";
        }

        model.addAttribute("result", result);

        return "loginResult";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; //회원가입 화면, view name --> templates
    }
}
