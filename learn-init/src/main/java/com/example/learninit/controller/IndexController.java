package com.example.learninit.controller;

import com.example.learninit.service.IndexService;
import com.example.learninit.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/index")
public class IndexController {
    private IndexService indexService;

    @Autowired
    public void setIndexService(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/hello")
    public String queryByArray() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return DateTimeUtils.getString(localDateTime);
    }
}
