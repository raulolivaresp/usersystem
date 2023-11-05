package com.ey.usersystem.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static String PATTERN_EMAIL = "(\\w+@\\w+\\.\\w{1,3})";
    private static String PATTERN_PASSWORD = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])";

    public void validEmail(String email){

        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new ValidException("Invalid email");
        }
        
    }

    public void validPassword(String password){

        Pattern pattern = Pattern.compile(PATTERN_PASSWORD);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.find()) {
            throw new ValidException("Invalid password");
        } 

    }
    
}
