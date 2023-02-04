package com.albert.instance;

import com.albert.instance.dao.BookDao;
import com.albert.instance.dao.OrderDao;
import com.albert.instance.dao.StudentDao;
import com.albert.instance.dao.UserDao;
import com.albert.instance.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("构造方式");
        function01(applicationContext);
        System.out.println("静态工厂方式");
        function02(applicationContext);
        System.out.println("实例工厂方式");
        function03(applicationContext);
        System.out.println("FactoryBean方式");
        function04(applicationContext);
    }

    public static void function01(ApplicationContext applicationContext) {
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.save();
        System.out.println("单例/多例");
        BookDao a = (BookDao) applicationContext.getBean("bookDao1");
        BookDao b = (BookDao) applicationContext.getBean("bookDao1");
        System.out.println(a);
        System.out.println(b);
    }

    public static void function02(ApplicationContext applicationContext) {
        OrderDao orderDao = (OrderDao) applicationContext.getBean("orderDao");
        orderDao.save();
    }


    public static void function03(ApplicationContext applicationContext) {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }

    public static void function04(ApplicationContext applicationContext) {
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
        studentDao.save();
    }


}