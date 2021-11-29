package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.model.User;
import com.richieoscar.flightreservation.repo.UserRepository;
import com.richieoscar.flightreservation.util.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private  UserRepository repository;


    @Override
    public User registerUser(User user) {
        boolean valid = Validate.validateUserData(user);
        if(valid){
            return  repository.save(user);
        }
        else throw new IllegalStateException("User credentials not valid");

    }

    @Override
    public void deleteUser(User user) {
        Optional<User> optionalUser = repository.findById(user.getId());
        boolean isPresent = optionalUser.isPresent();
        if(isPresent){
            repository.delete(optionalUser.get());
        }

        else throw new IllegalStateException("User with" +user.getId() +" does not exist");


    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User updateUser(Long Id) {
        Optional<User> userExist = repository.findById(Id);
        if(userExist.isPresent()){
            return  repository.save(userExist.get());
        }
        else throw new
                IllegalStateException("User does not exist");

    }

    @Override
    public boolean verifyUser(Long id) {
        return repository.existsById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return repository.findByEmail(email);

    }


    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }
}
