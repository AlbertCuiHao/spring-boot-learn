package com.albert.ioc.service.impl;

import com.albert.ioc.dao.BookDao;
import com.albert.ioc.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
}
