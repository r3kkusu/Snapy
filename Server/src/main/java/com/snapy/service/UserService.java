package com.snapy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snapy.model.User;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(new User(
            "r3kkusu",
            "rexjamesp@gmail.com",
            "password"
        ));
    }
    
}
