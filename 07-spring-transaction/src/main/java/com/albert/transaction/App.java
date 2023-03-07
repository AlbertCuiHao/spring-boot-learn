package com.albert.transaction;


import com.albert.transaction.config.SpringConfig;
import com.albert.transaction.service.BankService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BankService bankService = context.getBean(BankService.class);
        bankService.transfer("A", "B", 50);
    }
}