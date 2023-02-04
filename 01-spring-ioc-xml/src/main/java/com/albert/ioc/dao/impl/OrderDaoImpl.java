package com.albert.ioc.dao.impl;

import com.albert.ioc.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {
    public OrderDaoImpl() {
        System.out.println("OrderDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("OrderDaoImpl save");
    }
}
