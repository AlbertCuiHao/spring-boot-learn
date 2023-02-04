package com.albert.lifecycle;

import com.albert.lifecycle.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("bean生命周期");
        function05();
        System.out.println("bean生命周期");
        function06();
    }

    public static void function05() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) context.getBean("bookDao1");
        bookDao.save();
        context.close();
    }

    public static void function06() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();
        BookDao bookDao = (BookDao) context.getBean("bookDao1");
        bookDao.save();
    }
}