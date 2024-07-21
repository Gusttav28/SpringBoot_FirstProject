package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserModels;
import com.api.crud.repositories.IUserRepositorie;

@Service
public class UserServices {
    
    @Autowired //this work for injections dependencys
    IUserRepositorie userRepositorie;

    public ArrayList<UserModels>  getuUserModels(){
        return (ArrayList<UserModels>) userRepositorie.findAll();
    }

    public UserModels saveUser(UserModels user){
        return userRepositorie.save(user);
    }

    public Optional<UserModels> getbyID(Long Id){
        return userRepositorie.findById(Id);
    }
    public UserModels updateByid(UserModels request, Long Id){
        UserModels user = userRepositorie.findById(Id).get();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());

        return user;
    }

    public boolean deleteUser(long id){
        try {
            userRepositorie.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
