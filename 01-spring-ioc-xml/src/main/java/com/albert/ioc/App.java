package com.albert.ioc;

import com.albert.ioc.dao.OrderDao;
import com.albert.ioc.dao.UserDao;
import com.albert.ioc.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        获取IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        获取Bean
        System.out.println("构造方式");
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.save();

//        BookDao bookDao1 = (BookDao) applicationContext.getBean("bookDao1");
//        BookDao bookDao2 = (BookDao) applicationContext.getBean("bookDao1");
//        System.out.println(bookDao1);
//        System.out.println(bookDao2);
        System.out.println("静态工厂方式");
        OrderDao orderDao = (OrderDao) applicationContext.getBean("orderDao");
        orderDao.save();
        System.out.println("实例工厂方式");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.save();
        System.out.println("FactoryBean");
        UserDao userDao1 = (UserDao) applicationContext.getBean("userDaoBean");
        userDao1.save();
    }
}