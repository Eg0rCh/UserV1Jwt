package com.example.userv1jwt.domain.user;

import lombok.Data;

import java.util.Set;
@Data
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;
    private Set<Role> roles;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;

    }

    public User() {

    }
}
