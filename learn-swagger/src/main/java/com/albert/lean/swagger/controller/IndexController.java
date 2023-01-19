package com.albert.lean.swagger.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

/**
 * @author Albert
 */
@Api(tags = "IndexController")
@RestController
@RequestMapping("/index")
public class IndexController {
    @Operation(summary = "demo接口")
    @GetMapping("/demo")
    public String getString(@Parameter(description = "测试id") @RequestParam(required = true) String id,
                            @Parameter(description = "测试name") @RequestParam(required = false) String name) {
        StringJoiner stringJoiner = new StringJoiner("", "[", "]");
        stringJoiner.add(id).add(name);
        return stringJoiner.toString();
    }
}
