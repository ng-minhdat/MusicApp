package com.eazybytes.backend.service;

import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.dto.UserDto;
import com.eazybytes.backend.exception.UserAlreadyExistsException;
import com.eazybytes.backend.mapper.UserMapper;
import com.eazybytes.backend.model.User;
import com.eazybytes.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException(String.format("User with username '%s' already exists", userDto.getUsername()));
        }
        User newUser = UserMapper.mapToUser(userDto, new User());
        userRepository.save(newUser);
    }
}
