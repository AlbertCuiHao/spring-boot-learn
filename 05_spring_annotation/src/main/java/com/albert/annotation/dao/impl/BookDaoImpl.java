package com.albert.annotation.dao.impl;


import com.albert.annotation.dao.BookDao;
import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDaoImpl implements BookDao {

    public BookDaoImpl() {
        System.out.println("BookDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("BookDaoImpl save...");
    }
}
