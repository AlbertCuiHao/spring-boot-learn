package com.example.learnweb.controller;

import com.example.learnweb.info.UserInfoVo;
import com.example.learnweb.result.ApiModel;
import com.example.learnweb.result.ApiStatus;
import com.example.learnweb.service.IndexService;
import com.example.learnweb.util.DateTimeUtils;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/index")
@Validated
public class IndexController {
    private IndexService indexService;

    @Autowired
    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/success")
    public ApiModel<String> success() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return ApiModel.success(DateTimeUtils.getString(localDateTime));
    }

    @GetMapping("/error")
    public ApiModel<String> error() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int a = 1 / 0;
        return ApiModel.success(DateTimeUtils.getString(localDateTime));
    }

    @GetMapping("/param")
    public ApiStatus requestParam(@Pattern(regexp = "^[1-9]\\d*$", message = "格式错误") @RequestParam String age) {

        return ApiStatus.SUCCESS;
    }

    @PostMapping("/body")
    public ApiStatus requestBody(@RequestBody @Validated UserInfoVo userInfoVo) {

        return ApiStatus.SUCCESS;
    }
}
