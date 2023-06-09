package com.example.userv1jwt.repository;

import com.example.userv1jwt.domain.user.Role;
import com.example.userv1jwt.domain.user.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id); // test
    Optional<User> findByUsername(String username);

    void update(User user); // test
    User create(User user);  // test

    void insertUserRole(@Param("userId") Long userId, @Param("role") Role role);
    void delete(Long id);

    List<User> findAllUsers();


}
