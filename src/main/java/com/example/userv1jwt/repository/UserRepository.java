package com.example.userv1jwt.repository;

import com.example.userv1jwt.domain.user.Role;
import com.example.userv1jwt.domain.user.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);

    void update(User user);
    void create(User user);

    void insertUserRole(@Param("userId") Long userId, @Param("role") Role role);
    void delete(Long id);


}
