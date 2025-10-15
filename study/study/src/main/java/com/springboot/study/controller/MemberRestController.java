package com.springboot.study.controller;

import com.springboot.study.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberRestController {
    @PostMapping("/restLogin")
    @ResponseBody
    public Map<String, Boolean> restLogin(@RequestBody Member member) {
        boolean result = false;
        if(member.getId().equals("test") && member.getPass().equals("1234")) result = true;

        //Map 객체를 생성하여 전송 --> 자동으로 JSON 객체로 변환

        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("result", result);

        // return {"result":"로그인 성공!"};
        return response; //호출한 페이지로 문자열 혹은 JSON 객체로 전송 : {"result": true}
    }

    @GetMapping("/restLogin")
    public String restLogin() {
        return "restLogin"; //view name
    }
}
