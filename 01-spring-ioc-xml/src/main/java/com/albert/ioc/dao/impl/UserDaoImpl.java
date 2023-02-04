package com.albert.ioc.dao.impl;

import com.albert.ioc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("UserDaoImpl save");
    }
}
