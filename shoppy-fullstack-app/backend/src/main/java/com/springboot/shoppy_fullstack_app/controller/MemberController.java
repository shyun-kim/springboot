package com.springboot.shoppy_fullstack_app.controller;

import com.springboot.shoppy_fullstack_app.dto.Member;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins="http://localhost:3000")
public class MemberController {
    @PostMapping("/login")
    public boolean login(@RequestBody Member member) {
        boolean result = false;
        if (member.getId().equals("test") && member.getPwd().equals("1234")) result=true;

        return result;
    }

    @PostMapping("/signup")
    public boolean signup(@RequestBody Member member) {
        boolean result = true;
        System.out.println(member.getId());
        System.out.println(member.getPwd());
        System.out.println(member.getName());
        System.out.println(member.getPhone());
        System.out.println(member.getEmail());

        return result;
    }

    @PostMapping("/idcheck")
    public String idcheck(@RequestBody Member member){
        boolean result = false;
        String msg = "";
        if(result) msg = "이미 등록된 아이디 입니다.";
        else msg = "등록 가능한 아이디 입니다.";

        return msg;
    }
}
