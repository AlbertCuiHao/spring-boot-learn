package com.albert.transaction.service.impl;

import com.albert.transaction.dao.BankDao;
import com.albert.transaction.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    private BankDao bankDao;

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public void transfer() {
        bankDao.in("B", 50);
        int i = 1 / 0;
        bankDao.out("A", 50);
    }
}
