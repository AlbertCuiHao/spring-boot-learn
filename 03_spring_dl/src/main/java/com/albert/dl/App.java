package com.albert.dl;

import com.albert.dl.service.IndexService;
import com.albert.dl.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //function01();
        function02();
    }

    public static void function01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService testService = (TestService) context.getBean("testService");
        testService.save();
    }

    public static void function02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IndexService indexService = (IndexService) context.getBean("indexService");
        indexService.save();
    }
}