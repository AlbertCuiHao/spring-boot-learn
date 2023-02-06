package com.albert.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        HikariDataSource hikariDataSource = context.getBean("dataSource", HikariDataSource.class);
        System.out.println(hikariDataSource);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(hikariDataSource);
        System.out.println(jdbcTemplate);
    }
}