package com.splitwise.splitwise2023;

import com.splitwise.splitwise2023.controllers.UserController;
import com.splitwise.splitwise2023.dtos.LoginUserRequestDto;
import com.splitwise.splitwise2023.dtos.RegisterUserRequestDto;
import com.splitwise.splitwise2023.dtos.UpdateProfileRequestDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Splitwise2023Application implements CommandLineRunner {

	private UserController userController;

	@Autowired
	public Splitwise2023Application(UserController userController) {
		this.userController = userController;
	}

	public static void main(String[] args) {
		SpringApplication.run(Splitwise2023Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
//		registerUserRequestDto.setUsername("Aravind");
//		registerUserRequestDto.setPhoneNumber("8754562843");
//		registerUserRequestDto.setPassword("Arav@2023");
//		this.userController.registerUser(registerUserRequestDto);
		LoginUserRequestDto loginUserRequestDto = new LoginUserRequestDto();
		loginUserRequestDto.setId(1L);
		loginUserRequestDto.setPassword("Arav@2023");
		this.userController.loginuser(loginUserRequestDto);

		UpdateProfileRequestDto updateProfileRequestDto = new UpdateProfileRequestDto();
		updateProfileRequestDto.setUserId(1l);
		updateProfileRequestDto.setNewPassword("Ragav@2023");
		this.userController.updateProfile(updateProfileRequestDto);

//		LoginUserRequestDto loginUserRequestDto1 = new LoginUserRequestDto();
//		loginUserRequestDto1.setId(1L);
//		loginUserRequestDto1.setPassword("Arav@20239");
//		this.userController.loginuser(loginUserRequestDto1);
	}
}
