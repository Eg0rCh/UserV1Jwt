package com.example.userv1jwt;

import com.example.userv1jwt.config.ApplicationConfig;
import com.example.userv1jwt.domain.user.User;
import com.example.userv1jwt.repository.impl.UserRepositoryImpl;
import com.example.userv1jwt.repository.mappers.DataSourceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJdbcTest
public class TestOneRepo {
    @Autowired
    private UserRepositoryImpl userRepository;


    @Autowired
    private DataSourceConfig dataSourceConfig;



    @Test
    void testCreate() throws Exception {
        User user = new User("Karl", "karl@gmail.com", "12345");
        Connection connection = dataSourceConfig.getConnection();
        User createdUser = userRepository.create(user);
//        assertNotNull(createdUser.getName());
//        assertEquals(user.getName(), createdUser.getName());
//        assertEquals(user.getUsername(), createdUser.getUsername());
//        assertEquals(user.getPassword(), createdUser.getPassword());

    }

    @Test
    void testCreateEntity() throws Exception {
        User user = userRepository.create( new User("Ivan", "ivan@mail.com", "12345") );
        assertThat(user).hasFieldOrPropertyWithValue("name", "Ivan");
        assertThat(user).hasFieldOrPropertyWithValue("username", "Ivan@mail.com");
        assertThat(user).hasFieldOrPropertyWithValue("password", "12345");
    }


}
