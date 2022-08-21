package com.snapy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapy.repositories.UserRepository;
import com.snapy.model.User;

@Service
public class AuthService {

    private final UserRepository userRespository;

    @Autowired
    public AuthService(UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    public Boolean register(User user) {

        if (userRespository.find(user.getEmail(), user.getUsername()).size() > 0) {
            return false;
        }

        userRespository.save(user);
        return true;
    }

    public List<User> getAll() {
        return userRespository.findAll();
    }
}
