package com.splitwise.splitwise2023.services.passwordencoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements PassWordEncoder{
    private BCryptPasswordEncoder springBcryptEncoder = new BCryptPasswordEncoder();

    @Override
    public String getEncodedPassword(String realPassword) {
        return springBcryptEncoder.encode(realPassword);
    }

    @Override
    public boolean matches(String realPassword, String hashedPassword) {
        return springBcryptEncoder.matches(realPassword,hashedPassword);
    }
}
