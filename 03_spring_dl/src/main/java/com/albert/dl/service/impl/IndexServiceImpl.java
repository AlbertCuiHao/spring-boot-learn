package com.albert.dl.service.impl;

import com.albert.dl.dao.BookDao;
import com.albert.dl.dao.UserDao;
import com.albert.dl.service.IndexService;

public class IndexServiceImpl implements IndexService {
    private BookDao bookDao;
    private UserDao userDao;

    public IndexServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("IndexServiceImpl save");
        bookDao.save();
        userDao.save();
    }
}
