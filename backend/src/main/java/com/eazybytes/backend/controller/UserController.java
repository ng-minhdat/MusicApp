package com.eazybytes.backend.controller;

import com.eazybytes.backend.constants.ResponseConstants;
import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.dto.UserDto;
import com.eazybytes.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ResponseConstants.STATUS_201, ResponseConstants.MESSAGE_201));
    }
}
