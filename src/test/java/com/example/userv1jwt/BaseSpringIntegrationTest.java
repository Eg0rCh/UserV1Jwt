package com.example.userv1jwt;

import liquibase.Liquibase;
import liquibase.integration.spring.SpringLiquibase;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

@SpringBootTest
@Transactional
@EnableConfigurationProperties
@Testcontainers
public class BaseSpringIntegrationTest extends BaseSpringTest{

    @Container
    private static final TestContainersConfig.CustomPostgreSQLContainer postgresql = TestContainersConfig
            .CustomPostgreSQLContainer.getInstance();

    @BeforeAll
    public static void migrateLiquibase(@Autowired DataSource dataSource){
        var liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db.changelog.yaml");
        liquibase.setDefaultSchema("schema");
        liquibase.setShouldRun(true);


    }


}
