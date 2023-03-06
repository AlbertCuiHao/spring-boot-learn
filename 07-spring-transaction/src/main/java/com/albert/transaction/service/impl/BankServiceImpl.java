package com.albert.transaction.service.impl;

import com.albert.transaction.dao.BankDao;
import com.albert.transaction.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankServiceImpl implements BankService {
    private BankDao bankDao;

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

//        REQUIRED：默认值，支持当前事务，如果没有事务会创建一个新的事务
//        SUPPORTS：支持当前事务，如果没有事务的话以非事务方式执行
//        MANDATORY：支持当前事务，如果没有事务抛出异常
//        REQUIRES_NEW：创建一个新的事务并挂起当前事务
//        NOT_SUPPORTED：以非事务方式执行，如果当前存在事务则将当前事务挂起
//        NEVER：以非事务方式进行，如果存在事务则抛出异常
//        NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则进行与REQUIRED类似的操作
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transfer() {
        bankDao.in("B", 50);
        int i = 1 / 0;
        bankDao.out("A", 50);
    }
}
