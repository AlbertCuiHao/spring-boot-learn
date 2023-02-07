package com.albert.transaction.dao;

public interface BankDao {
    void in(String name, int money);

    void out(String name, int money);
}
