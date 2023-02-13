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
    @GetMapping(value = "/request-param", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String requestParam(@RequestParam("name") String name) {
        System.out.println(name);
        return name;
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
