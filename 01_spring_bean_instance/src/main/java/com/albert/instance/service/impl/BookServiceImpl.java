package com.albert.instance.service.impl;

import com.albert.instance.dao.BookDao;
import com.albert.instance.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("BookServiceImpl save");
        bookDao.save();
    }
}
