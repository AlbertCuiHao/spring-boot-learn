package com.albert.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.albert.annotation"})
@PropertySource({"classpath:jdbc.properties"})
public class SpringConfig {
}
