package com.albert.instance.factory;

import com.albert.instance.dao.OrderDao;
import com.albert.instance.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao() {
        System.out.println("OrderDaoFactory setup ...");
        return new OrderDaoImpl();
    }
}
