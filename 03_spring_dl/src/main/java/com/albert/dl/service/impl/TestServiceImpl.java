package com.albert.dl.service.impl;


import com.albert.dl.dao.BookDao;
import com.albert.dl.dao.UserDao;
import com.albert.dl.service.TestService;

public class TestServiceImpl implements TestService {
    private BookDao bookDao;
    private UserDao userDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("BookServiceImpl save");
        bookDao.save();
        userDao.save();
    }


}
