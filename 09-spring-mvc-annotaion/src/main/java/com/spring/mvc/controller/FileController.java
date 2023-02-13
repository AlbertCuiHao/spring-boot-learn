package com.spring.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
}
