package com.splitwise.splitwise2023.services.user;

import com.splitwise.splitwise2023.exceptions.InvalidCredentialsException;
import com.splitwise.splitwise2023.models.User;
import com.splitwise.splitwise2023.repositories.UserRepository;
import com.splitwise.splitwise2023.services.passwordencoder.PassWordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.InvalidAttributesException;
import java.security.InvalidParameterException;

@Service
public class UserService {
    private UserRepository userRepository;
    private PassWordEncoder passWordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PassWordEncoder passWordEncoder) {
        this.userRepository = userRepository;
        this.passWordEncoder=passWordEncoder;
    }

    public User registerUser(String phoneNumber, String password, String username)
    {
        User user = new User();
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        user.setHashedPassword(passWordEncoder.getEncodedPassword(password));

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    public User login(Long userId, String password) throws InvalidCredentialsException {
        User user = userRepository.findById(userId).get();
        if(!passWordEncoder.matches(password,user.getHashedPassword()))
        {
            throw new InvalidCredentialsException("Invalid Credentials!");
        }
        else{
            System.out.println("Logged In Successfully!");
        }
        return userRepository.findById(userId).get();
    }

    public User updateProfile(Long userId, String password)
    {
        User user = userRepository.findById(userId).get();
        user.setHashedPassword(passWordEncoder.getEncodedPassword(password));
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
