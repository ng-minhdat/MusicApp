package com.eazybytes.backend.service;

import com.eazybytes.backend.dto.ResponseDto;
import com.eazybytes.backend.dto.UserDto;
import com.eazybytes.backend.exception.ResourceNotFoundException;
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

    public void updateUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "username", userDto.getUsername());
        }
        User updatedUser = UserMapper.mapToUser(userDto, optionalUser.get());
        userRepository.save(updatedUser);
    }

    public UserDto getUser(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "username", username);
        }
        UserDto userDto = UserMapper.mapToUserDto(optionalUser.get(), new UserDto());
        return userDto;
    }

    public void deleteUser(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new ResourceNotFoundException("User", "username", username);
        }
        userRepository.delete(optionalUser.get());
    }
}
