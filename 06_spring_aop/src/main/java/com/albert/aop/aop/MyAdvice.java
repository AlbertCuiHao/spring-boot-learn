package com.albert.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {

    //    @Pointcut("execution(void com.albert.aop.dao.impl.BookDaoImpl.save())")
    @Pointcut("execution(* com.albert.aop.dao.impl.*.*(..))")
    public void point() {

    }

    @Before(value = "point()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before ");
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
    }

    @After(value = "point()")
    public void after() {
        System.out.println("After");
    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println(className + ":" + methodName + "->" + "proceed before");

        Object proceed = proceedingJoinPoint.proceed();
        System.out.println(className + ":" + methodName + ":->" + "proceed After");
        return proceed;
    }

}
