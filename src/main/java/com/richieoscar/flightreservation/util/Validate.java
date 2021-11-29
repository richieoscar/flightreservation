package com.richieoscar.flightreservation.util;

import com.richieoscar.flightreservation.model.User;

import java.util.Optional;

public class Validate {
    private static final int PASSWORD_LENGTH = 6;

    public static boolean validateUserData(User user){
        if(user.getFirstName()==null || user.getLastName() ==null){
            throw new IllegalStateException("First name or Last name missing");
        }
        if(user.getPassword().length()<PASSWORD_LENGTH){
            throw new  IllegalStateException("Password must be more than 6 characters");
        }
        if(user.getEmail()==null){
            throw new IllegalStateException("Email is required");
        }
        return true;
    }
}
