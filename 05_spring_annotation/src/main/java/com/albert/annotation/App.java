package com.albert.annotation;

import com.albert.annotation.config.SpringConfig;
import com.albert.annotation.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = context.getBean("bookDao", BookDao.class);
        bookDao.save();
    }
}