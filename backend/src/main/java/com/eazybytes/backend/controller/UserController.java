package com.eazybytes.backend.controller;

import com.eazybytes.backend.constants.ResponseConstants;
import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.dto.UserDto;
import com.eazybytes.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }

    @GetMapping("/get")
    public ResponseEntity<UserDto> getUser(@RequestParam String username) {
        UserDto userDto = userService.getUser(username);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteUser(@RequestParam String username) {
        userService.deleteUser(username);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseConstants.STATUS_200, ResponseConstants.MESSAGE_200));
    }
}
