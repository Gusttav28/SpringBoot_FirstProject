package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.UserModels;

@Repository //This is for create quarys into a data bases
public interface IUserRepositorie extends JpaRepository<UserModels,Long> {
    
    
    
}