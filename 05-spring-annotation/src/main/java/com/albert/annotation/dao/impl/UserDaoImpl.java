package com.albert.annotation.dao.impl;


import com.albert.annotation.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Scope("prototype")
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl constructor is running");
    }


    public void save() {
        System.out.println("UserDaoImpl save...");
    }
}
