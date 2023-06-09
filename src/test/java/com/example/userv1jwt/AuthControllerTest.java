package com.example.userv1jwt;

import com.example.userv1jwt.config.ApplicationConfig;
import com.example.userv1jwt.domain.user.User;
import com.example.userv1jwt.service.AuthService;
import com.example.userv1jwt.service.UserService;
import com.example.userv1jwt.web.controller.AuthController;
import com.example.userv1jwt.web.dto.auth.JwtRequest;
import com.example.userv1jwt.web.dto.auth.JwtResponse;
import com.example.userv1jwt.web.dto.user.UserDto;
import com.example.userv1jwt.web.dto.validation.OnCreate;
import com.example.userv1jwt.web.mappers.UserMapper;
import com.example.userv1jwt.web.security.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Import(ApplicationConfig.class)
@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;
    @MockBean
    private UserService userService;
    @MockBean
    private UserMapper userMapper;

    @Mock
    private UserDto userDto;
    @Mock
    private User user;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    private String jwtToken;


    @Test
    void login() throws Exception {

        this.mockMvc.perform(post("/api/v1/auth/login").content("""
                                {
                                "username": "johndoe@gmail.com",
                                "password": "12345"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, "application/json")
                )
                .andDo(print())
                .andExpect(status().isOk());


    }



}
