package com.splitwise.splitwise2023;

import com.splitwise.splitwise2023.commands.CommandsRegistry;
import com.splitwise.splitwise2023.controllers.GroupController;
import com.splitwise.splitwise2023.controllers.UserController;
import com.splitwise.splitwise2023.dtos.CreateGroupRequestDto;
import com.splitwise.splitwise2023.dtos.LoginUserRequestDto;
import com.splitwise.splitwise2023.dtos.RegisterUserRequestDto;
import com.splitwise.splitwise2023.dtos.UpdateProfileRequestDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Splitwise2023Application implements CommandLineRunner {

//	private UserController userController;
//	private GroupController groupController;
//
//	@Autowired
//	public Splitwise2023Application(UserController userController, GroupController groupController) {
//		this.userController = userController;
//		this.groupController=groupController;
//	}

	@Autowired
	private CommandsRegistry commandsRegistry;

	public static void main(String[] args) {
		SpringApplication.run(Splitwise2023Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true)
		{
			Scanner scanner = new Scanner(System.in);

			String input = scanner.nextLine();

			commandsRegistry.execute(input);
		}
	}

//	@Override
//	public void run(String... args) throws Exception {
//
////		RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
////		registerUserRequestDto.setUsername("Aravind");
////		registerUserRequestDto.setPhoneNumber("8754562843");
////		registerUserRequestDto.setPassword("Arav@2023");
////		this.userController.registerUser(registerUserRequestDto);
//		LoginUserRequestDto loginUserRequestDto = new LoginUserRequestDto();
//		loginUserRequestDto.setId(1L);
//		loginUserRequestDto.setPassword("Ragav@2023");
//		this.userController.loginuser(loginUserRequestDto);
//
//		UpdateProfileRequestDto updateProfileRequestDto = new UpdateProfileRequestDto();
//		updateProfileRequestDto.setUserId(1l);
//		updateProfileRequestDto.setNewPassword("Ragav@2023");
//		this.userController.updateProfile(updateProfileRequestDto);
//
////		LoginUserRequestDto loginUserRequestDto1 = new LoginUserRequestDto();
////		loginUserRequestDto1.setId(1L);
////		loginUserRequestDto1.setPassword("Arav@20239");
////		this.userController.loginuser(loginUserRequestDto1);
//
//		CreateGroupRequestDto createGroupRequestDto = new CreateGroupRequestDto();
//		createGroupRequestDto.setName("GOA");
//		createGroupRequestDto.setCreatedByUserId(1L);
//		createGroupRequestDto.setDescription("GOA POROM, FUN PANROM!");
//
//		this.groupController.createGroup(createGroupRequestDto);
//	}
}
