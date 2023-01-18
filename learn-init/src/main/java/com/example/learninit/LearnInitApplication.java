package com.example.learninit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnInitApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(LearnInitApplication.class);
        //springApplication.setBanner();
        springApplication.run(args);
    }

}
