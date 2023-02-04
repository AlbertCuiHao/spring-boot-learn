package com.albert.instance.dao.impl;

import com.albert.instance.dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl() {
        System.out.println("BookDaoImpl constructor is running");
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }

    public void save() {
        System.out.println("BookDaoImpl save");
    }
}
