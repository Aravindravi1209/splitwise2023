package com.splitwise.splitwise2023.services.passwordencoder;

public interface PassWordEncoder {
    String getEncodedPassword(String realPassword);
    boolean matches(String realPasswprd, String hashedPassword);
}
