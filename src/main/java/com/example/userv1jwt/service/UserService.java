package com.example.userv1jwt.service;

import com.example.userv1jwt.domain.user.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);

    void delete(Long id);
}
