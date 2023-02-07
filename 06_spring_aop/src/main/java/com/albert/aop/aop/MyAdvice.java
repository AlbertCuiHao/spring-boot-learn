package com.albert.aop.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.albert.aop.dao.impl.BookDaoImpl.save())")
    public void point() {

    }

    @Before(value = "point()")
    public void before() {
        System.out.println("before ");
    }

    @After(value = "point()")
    public void after() {
        System.out.println("AfterReturning");
    }
}
