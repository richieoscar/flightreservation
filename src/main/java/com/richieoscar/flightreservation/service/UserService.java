package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.model.AppUser;

import java.util.List;

public interface UserService {

    AppUser registerUser(AppUser appUser);

    void deleteUser(AppUser appUser);

    void deleteUserById(Long id);

    AppUser updateUser(Long Id);

    boolean verifyUser(Long id);

    AppUser findUserByEmail(String email);

    List<AppUser> getUsers();
}
