package com.crud.controller;

import com.crud.payload.LoginDto;
import com.crud.payload.ResponseDto;
import com.crud.payload.UserDto;
import com.crud.security.JwtTokenProvider;
import com.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto saveNewUser = this.service.createUser(userDto);
        logger.info("Register new User successfully Registered Email : " + saveNewUser.getUserEmail());
        return new ResponseEntity<>(saveNewUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUserEmail(),
                        loginDto.getPassword()));
        logger.info("User Login Successfully ! ");
        System.out.println(authenticate);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        // get the token

        String token = jwtTokenProvider.generateToken(authenticate);
        return ResponseEntity.ok(new ResponseDto(token));
    }
}
