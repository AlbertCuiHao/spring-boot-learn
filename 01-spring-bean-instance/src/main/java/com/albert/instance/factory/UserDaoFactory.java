package com.albert.instance.factory;

import com.albert.instance.dao.UserDao;
import com.albert.instance.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao() {
        System.out.println("UserDaoFactory setup ...");
        return new UserDaoImpl();
    }
}
