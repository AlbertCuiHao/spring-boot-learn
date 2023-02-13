package com.spring.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @GetMapping("/test")
    public String test() {
        int a = 1 / 0;
        return "success";
    }

    @GetMapping("/arithmetic-exception")
    public String arithmeticException(HttpServletRequest request) {
        Object msg = request.getAttribute("msg");
        if (msg != null) {
            return String.valueOf(msg);
        } else {
            return "";
        }
    }
}
