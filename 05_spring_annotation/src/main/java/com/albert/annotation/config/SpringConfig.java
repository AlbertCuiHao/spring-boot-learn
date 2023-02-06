package com.albert.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.albert.annotation.dao.impl")
public class SpringConfig {
}
