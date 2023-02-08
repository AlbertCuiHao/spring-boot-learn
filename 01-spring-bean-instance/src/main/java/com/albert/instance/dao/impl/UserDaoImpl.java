package com.albert.instance.dao.impl;

import com.albert.instance.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("UserDaoImpl save");
    }
}
