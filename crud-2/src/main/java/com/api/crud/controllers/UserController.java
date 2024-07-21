package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

import com.api.crud.models.UserModels;
import com.api.crud.services.UserServices;

import jakarta.persistence.Id;

@RestController
@RequestMapping("/user") //defing the rute
public class UserController {
    
    //we are ininjecting a dependency
    @Autowired
    private UserServices userServices;
    @GetMapping
    public ArrayList<UserModels> getUserModels(){
        //First request created
        return this.userServices.getuUserModels();
    }

    @PostMapping 
    public UserModels saveUser(@RequestBody UserModels user){
        return this.userServices.saveUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModels> getUserById(@PathVariable("id") Long Id){
        return this.userServices.getbyID(Id);
    }
    @PutMapping(path = "/{id}")
    public UserModels updateUserById(@RequestBody UserModels request, @PathVariable("Id")long Id){
        return this.userServices.updateByid(request, Id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletebyId(@PathVariable("Id")long Id){
        boolean ok = this.userServices.deleteUser(Id);
        if (ok){
            return "User with id " + Id + " Deleted";
        } else{
            return "Error, we have a problem and we can't delete the user with id: " + Id;
        }
    }
}
