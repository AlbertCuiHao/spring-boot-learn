package com.albert.ioc.dao.impl;

import com.albert.ioc.dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("BookDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("BookDao save");
    }
}
