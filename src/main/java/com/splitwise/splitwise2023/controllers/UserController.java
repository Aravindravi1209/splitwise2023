package com.splitwise.splitwise2023.controllers;

import com.splitwise.splitwise2023.dtos.*;
import com.splitwise.splitwise2023.exceptions.InvalidCredentialsException;
import com.splitwise.splitwise2023.models.User;
import com.splitwise.splitwise2023.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/register")
    public RegisterUserResponseDto registerUser(@RequestBody RegisterUserRequestDto request) {
        User user = userService.registerUser(
                request.getPhoneNumber(),
                request.getPassword(),
                request.getUsername()
        );

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        registerUserResponseDto.setUser(user);
        return registerUserResponseDto;
    }

    public LoginUserResponseDto loginuser(LoginUserRequestDto requestDto) throws InvalidCredentialsException {
        LoginUserResponseDto loginUserResponseDto = new LoginUserResponseDto();
        loginUserResponseDto.setUser(this.userService.login(requestDto.getId(), requestDto.getPassword()));
        return loginUserResponseDto;
    }

    public UpdateProfileResponseDto updateProfile(UpdateProfileRequestDto requestDto)
    {
        UpdateProfileResponseDto responseDto = new UpdateProfileResponseDto();
        responseDto.setUser(this.userService.updateProfile(requestDto.getUserId(),requestDto.getNewPassword()));
        return responseDto;
    }
}
