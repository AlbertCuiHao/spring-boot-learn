package com.albert.annotation.service.impl;

import com.albert.annotation.dao.BookDao;
import com.albert.annotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("BookServiceImpl save...");
        bookDao.save();
    }
}
