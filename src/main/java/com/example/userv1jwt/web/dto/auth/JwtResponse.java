package com.example.userv1jwt.web.dto.auth;

import lombok.Data;

@Data
public class JwtResponse {

    private Long id;
    private String username;
    private String password;
    private String accessToken;
    private String refreshToken;
}
