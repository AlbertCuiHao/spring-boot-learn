package com.albert.annotation;

import com.albert.annotation.config.SpringConfig;
import com.albert.annotation.dao.UserDao;
import com.albert.annotation.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        //function01();
        //function02();
        function03();
    }

    public static void function01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.registerShutdownHook();
        UserDao a = context.getBean("userDao", UserDao.class);
        System.out.println(a);
        UserDao b = context.getBean("userDao", UserDao.class);
        System.out.println(b);
    }

    private static void function02() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.registerShutdownHook();
        BookService bookService = context.getBean(BookService.class);
        bookService.save();
    }

    private static void function03() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.registerShutdownHook();
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dataSource);
    }

}