package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/params", method = RequestMethod.GET)
    @ResponseBody
    public String params() {
        return "success";
    }

    @RequestMapping(value = "/pathvariable/{a}/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String pathvariable(@PathVariable("a") String id, @PathVariable("b") String username) {
        return id + username;
    }

    @GetMapping("/request-header")
    @ResponseBody
    public String requestHeader(@RequestHeader(name = "header") String header) {
        return header;
    }

    @GetMapping("/request-param")
    @ResponseBody
    public String requestParam(@RequestParam("requestParam") String requestParam) {
        System.out.println(requestParam);
        return requestParam;
    }

}
