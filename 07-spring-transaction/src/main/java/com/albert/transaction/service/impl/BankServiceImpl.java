package com.albert.transaction.service.impl;

import com.albert.transaction.dao.BankDao;
import com.albert.transaction.service.BankService;
import com.albert.transaction.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    private BankDao bankDao;

    private LogService logService;

    @Autowired
    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Autowired
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void transfer(String in, String out, long money) {
        try {
            bankDao.in(in, money);
            int i = 1 / 0;
            bankDao.out(out, money);
        } finally {
            logService.log(in, out, money);
        }
    }
}
