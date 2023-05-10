package com.example.userv1jwt;

import com.example.userv1jwt.domain.user.User;
import com.example.userv1jwt.repository.UserRepository;
import com.example.userv1jwt.repository.impl.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RepositoryTest extends BaseSpringIntegrationTest{
    @Autowired
    UserRepositoryImpl userRepository;
    @Test
    public void testCreate() {
        var user = new User();

        User result = userRepository.create(user);

        assertThat(result.getId()).isNotNull();
    }
}
