package com.albert.ioc.factory;

import com.albert.ioc.dao.UserDao;
import com.albert.ioc.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao() {
        System.out.println("UserDaoFactory setup ...");
        return new UserDaoImpl();
    }
}
