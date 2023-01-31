package com.albert.ioc.factory;

import com.albert.ioc.dao.OrderDao;
import com.albert.ioc.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao() {
        System.out.println("OrderDaoFactory setup ...");
        return new OrderDaoImpl();
    }
}
