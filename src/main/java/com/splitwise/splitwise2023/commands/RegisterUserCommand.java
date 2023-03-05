package com.splitwise.splitwise2023.commands;

import com.splitwise.splitwise2023.controllers.UserController;
import com.splitwise.splitwise2023.dtos.RegisterUserRequestDto;
import com.splitwise.splitwise2023.dtos.RegisterUserResponseDto;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserCommand implements Command{

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        List<String> params = Arrays.stream(input.split(" ")).toList();
        if(params.size()!=4)
        {
            return false;
        }
        if(!params.get(0).equals(CommandKeywords.REGISTER_USER_COMMAND))
        {
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        List<String> params = Arrays.stream(input.split(" ")).toList();
        String userName = params.get(1);
        String phoneNumber = params.get(2);
        String passWord = params.get(3);

        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setPassword(passWord);
        registerUserRequestDto.setUsername(userName);
        registerUserRequestDto.setPhoneNumber(phoneNumber);

        RegisterUserResponseDto responseDto = this.userController.registerUser(registerUserRequestDto);
        System.out.println(responseDto.getUser());
        System.out.println("User registered!!");
    }
}
