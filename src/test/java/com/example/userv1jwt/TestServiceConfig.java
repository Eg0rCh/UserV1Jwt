package com.example.userv1jwt;

import com.example.userv1jwt.repository.mappers.DataSourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ImportAutoConfiguration(classes = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class,
        JdbcRepositoriesAutoConfiguration.class
})
@Import({
        DataSourceConfig.class
})
@ComponentScan(basePackages = {
        "com.example.userv1jwt.domain",
        "com.example.userv1jwt.service",
        "com.example.userv1jwt.web",
        "com.example.userv1jwt.repository",
        "com.example.userv1jwt.config"
})
public class TestServiceConfig {
}
