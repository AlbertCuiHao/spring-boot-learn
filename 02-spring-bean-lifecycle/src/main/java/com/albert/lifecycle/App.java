package com.albert.lifecycle;

import com.albert.lifecycle.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        System.out.println("close");
        function01();
        System.out.println("registerShutdownHook");
        function02();
    }

    public static void function01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
        context.close();
    }

    public static void function02() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
    }
}