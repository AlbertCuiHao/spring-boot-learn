package com.albert.transaction.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public interface BankService {
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class, ArithmeticException.class})
    void transfer();
}
