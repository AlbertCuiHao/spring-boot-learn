package com.spring.mvc.controller;

import com.spring.mvc.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/request-param")
    @ResponseBody
    public String requestParam(@RequestParam("requestParam") String requestParam) {
        System.out.println(requestParam);
        return requestParam;
    }

    @GetMapping("/response-body")
    @ResponseBody
    public UserEntity ResponseBody() {
        UserEntity entity = new UserEntity();
        entity.setName("张三");
        entity.setAge(15);
        return entity;
    }

}
