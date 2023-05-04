package com.example.userv1jwt.web.mappers;

import com.example.userv1jwt.domain.user.User;
import com.example.userv1jwt.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

}
