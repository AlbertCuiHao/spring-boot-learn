package com.albert.transaction.dao;

public interface BankDao {
    void in(String name, long money);

    void out(String name, long money);
}
