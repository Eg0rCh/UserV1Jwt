package com.example.userv1jwt.repository.mappers;

import com.example.userv1jwt.domain.user.Role;
import com.example.userv1jwt.domain.user.User;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class UserRowMapper {
    //@SneakyThrows
    public static User mapRow(ResultSet resultSet) {
        try {
            Set<Role> roles = new HashSet<>();
            while (resultSet.next()) {
                roles.add(Role.valueOf(resultSet.getString("user_role_role")));
            }
            resultSet.beforeFirst();

            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setName(resultSet.getString("user_name"));
                user.setUsername(resultSet.getString("user_username"));
                user.setPassword(resultSet.getString("user_password"));
                user.setRoles(roles);
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
