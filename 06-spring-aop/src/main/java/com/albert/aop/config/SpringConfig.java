package com.albert.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.albert.aop"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
