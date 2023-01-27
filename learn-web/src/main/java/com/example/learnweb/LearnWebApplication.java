package com.example.learnweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnWebApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(LearnWebApplication.class);
        //springApplication.setBanner();
        springApplication.run(args);
    }

}
