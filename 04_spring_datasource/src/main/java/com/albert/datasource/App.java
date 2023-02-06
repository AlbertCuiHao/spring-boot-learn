package com.albert.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        function01();
    }

    public static void function01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = """
                SELECT id, user_name, user_age, version_no, create_time, create_by, update_time, update_by
                FROM learn.demo_user du
                WHERE user_name = 'albert'
                """;
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);

    }
}