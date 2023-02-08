package com.albert.transaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.albert.transaction.dao", "com.albert.transaction.service"})
@PropertySource({"classpath:jdbc.properties"})
@Import({dataSourceConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
