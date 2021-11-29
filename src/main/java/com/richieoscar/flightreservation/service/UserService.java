package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.model.User;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    void deleteUser(User user);

    void deleteUserById(Long id);

    User updateUser(Long Id);

    boolean verifyUser(Long id);

    User findUserByEmail(String email);

    List<User> getUsers();
}
