package com.spring.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {
    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "interceptor";
    }
}
