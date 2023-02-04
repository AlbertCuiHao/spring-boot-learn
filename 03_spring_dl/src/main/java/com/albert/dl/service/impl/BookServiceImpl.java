package com.albert.dl.service.impl;

import com.albert.dl.dao.BookDao;
import com.albert.dl.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("BookServiceImpl save");
        bookDao.save();
    }
}
