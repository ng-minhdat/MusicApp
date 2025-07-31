package com.eazybytes.backend.dto;

import com.eazybytes.backend.model.UserStatus;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private UserStatus status;
    private String avatarPath;
}
