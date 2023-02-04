package com.albert.dl;

import com.albert.dl.service.BookService;
import com.albert.dl.service.IndexService;
import com.albert.dl.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        function01();
        function02();
        function03();
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

    public static void function03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.save();
    }
}