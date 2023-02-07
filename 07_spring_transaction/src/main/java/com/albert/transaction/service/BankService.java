package com.albert.transaction.service;

import org.springframework.transaction.annotation.Transactional;

public interface BankService {
    @Transactional
    void transfer();
}
