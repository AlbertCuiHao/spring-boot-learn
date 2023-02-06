package com.albert.annotaion;

import com.albert.annotaion.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        System.out.println(bookDao);
    }
}