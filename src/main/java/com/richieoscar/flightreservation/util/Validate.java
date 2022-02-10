package com.richieoscar.flightreservation.util;

import com.richieoscar.flightreservation.model.AppUser;

public class Validate {
    private static final int PASSWORD_LENGTH = 6;

    public static boolean validateUserData(AppUser appUser){
        if(appUser.getFirstName()==null || appUser.getLastName() ==null){
            throw new IllegalStateException("First name or Last name missing");
        }
        if(appUser.getPassword().length()<PASSWORD_LENGTH){
            throw new  IllegalStateException("Password must be more than 6 characters");
        }
        if(appUser.getEmail()==null){
            throw new IllegalStateException("Email is required");
        }
        return true;
    }
}
