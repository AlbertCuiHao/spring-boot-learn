package com.albert.learn.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @PreAuthorize("hasRole('ROLE_root')")
    @GetMapping("/root")
    public String hasRole() {
        return "ROLE_root";
    }

    @PreAuthorize("hasRole('ROLE_admin')")
    @GetMapping("/admin")
    public String root() {
        return "ROLE_admin";
    }
}
