package com.api.crud.services;

import java.util.ArrayList;

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
}
