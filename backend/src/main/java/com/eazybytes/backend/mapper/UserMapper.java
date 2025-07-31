package com.eazybytes.backend.mapper;

import com.eazybytes.backend.dto.UserDto;
import com.eazybytes.backend.model.User;

public class UserMapper {
    private UserMapper() {}

    public static User mapToUser(UserDto userDto, User user) {
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setStatus(userDto.getStatus());
        user.setAvatarPath(userDto.getAvatarPath());
        return user;
    }

    public static UserDto mapToUserDto(User user, UserDto userDto) {
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setStatus(user.getStatus());
        userDto.setAvatarPath(user.getAvatarPath());
        return userDto;
    }
}
