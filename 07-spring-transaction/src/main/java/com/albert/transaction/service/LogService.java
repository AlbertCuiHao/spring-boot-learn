package com.albert.transaction.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface LogService {
    /*    REQUIRED：默认值，支持当前事务，如果没有事务会创建一个新的事务
        SUPPORTS：支持当前事务，如果没有事务的话以非事务方式执行
        MANDATORY：支持当前事务，如果没有事务抛出异常
        REQUIRES_NEW：创建一个新的事务并挂起当前事务
        NOT_SUPPORTED：以非事务方式执行，如果当前存在事务则将当前事务挂起
        NEVER：以非事务方式进行，如果存在事务则抛出异常
        NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则进行与REQUIRED类似的操作*/
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void log(String in, String out, long money);
}
