package com.albert.annotation.dao.impl;


import com.albert.annotation.dao.BookDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

@Repository
//@Scope("prototype")
public class BookDaoImpl implements BookDao {

    public BookDaoImpl() {
        System.out.println("BookDaoImpl constructor is running");
    }

    @PostConstruct
    public void init() {
        System.out.println("BookDaoImpl init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BookDaoImpl destroy...");
    }

    public void save() {
        System.out.println("BookDaoImpl save...");
    }
}
