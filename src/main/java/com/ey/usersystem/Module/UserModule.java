package com.ey.usersystem.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ey.usersystem.Model.User;
import com.ey.usersystem.Repository.UserRepository;

@Component
public class UserModule {

    @Autowired
    UserRepository repository;


    public void saveUser(User user) {
        repository.save(user);
    }

    public User getUser(String email){

    

        User user = repository.findByEmail(email);

        return user;
    }
}
