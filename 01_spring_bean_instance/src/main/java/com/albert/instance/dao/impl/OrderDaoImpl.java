package com.albert.instance.dao.impl;

import com.albert.instance.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {
    public OrderDaoImpl() {
        System.out.println("OrderDaoImpl constructor is running");
    }

    public void save() {
        System.out.println("OrderDaoImpl save");
    }
}
