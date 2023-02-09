package com.spring.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/file")
public class FileController {
    @GetMapping("/download")
    public void download(HttpSession session, HttpServletResponse response) {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath(File.separator + "static" + File.separator + "1.png");
        System.out.println(realPath);
        File file = new File(realPath);
        if (file.exists()) {
            String filename = file.getName();
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file)); OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
                response.reset();
                response.setContentType("application/octet-stream;charset=UTF-8");
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes(), StandardCharsets.ISO_8859_1));

                byte[] buffer = new byte[1024];
                int count = -1;
                while ((count = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, count);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
