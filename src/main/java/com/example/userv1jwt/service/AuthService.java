package com.example.userv1jwt.service;

import com.example.userv1jwt.web.dto.auth.JwtRequest;
import com.example.userv1jwt.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
