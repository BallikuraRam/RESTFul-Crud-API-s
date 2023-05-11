package com.crud.service;

import com.crud.exception.UserNotFoundException;
import com.crud.model.Users;
import com.crud.payload.UserDto;
import com.crud.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersServiceImpl implements UserService {

    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Users users = userDtoToEntity(userDto);
        Users savedUser = this.repository.save(users);
        return entityToUserDto(savedUser);
    }

    private Users userDtoToEntity(UserDto userDto) {
        Users users = new Users();
        users.setUserName(userDto.getUserName());
        users.setUserEmail(userDto.getUserEmail());
        users.setPassword(userDto.getPassword());
        return users;
    }

    private UserDto entityToUserDto(Users users) {
        UserDto userDto = new UserDto();
        userDto.setUserId(users.getUserId());
        userDto.setUserName(users.getUserName());
        userDto.setUserEmail(users.getUserEmail());
        userDto.setPassword(users.getPassword());
        return userDto;
    }
}
