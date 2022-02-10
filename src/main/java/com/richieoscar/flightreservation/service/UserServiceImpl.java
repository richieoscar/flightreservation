package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.model.AppUser;
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
    public AppUser registerUser(AppUser appUser) {
        boolean valid = Validate.validateUserData(appUser);
        if(valid){
            return  repository.save(appUser);
        }
        else throw new IllegalStateException("User credentials not valid");

    }

    @Override
    public void deleteUser(AppUser appUser) {
        Optional<AppUser> optionalUser = repository.findById(appUser.getId());
        boolean isPresent = optionalUser.isPresent();
        if(isPresent){
            repository.delete(optionalUser.get());
        }

        else throw new IllegalStateException("User with" + appUser.getId() +" does not exist");


    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AppUser updateUser(Long Id) {
        Optional<AppUser> userExist = repository.findById(Id);
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
    public AppUser findUserByEmail(String email) {
        return repository.findByEmail(email);

    }


    @Override
    public List<AppUser> getUsers() {
        return repository.findAll();
    }
}
