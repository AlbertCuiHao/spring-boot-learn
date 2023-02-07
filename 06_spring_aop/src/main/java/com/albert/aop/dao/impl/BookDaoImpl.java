package com.albert.aop.dao.impl;


import com.albert.aop.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
//@Scope("prototype")
public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("BookDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("BookDaoImpl save...");
    }
}
