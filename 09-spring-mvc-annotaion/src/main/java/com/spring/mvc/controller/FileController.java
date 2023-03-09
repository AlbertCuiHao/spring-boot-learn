package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartHttpServletRequest request) {
        MultipartFile file = request.getFile("file");
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        return originalFilename;
    }

    @PostMapping("/importData")
    @ResponseBody
    public String importData(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            System.out.println(file.getOriginalFilename());
        }
        return "123";
    }
}
