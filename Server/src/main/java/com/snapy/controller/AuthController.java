package com.snapy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.snapy.model.User;
import com.snapy.service.AuthService;

@RestController
@RequestMapping(path = "api/v1/user")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> register(@RequestBody User user) {
        if (authService.register(user)) {
            return ResponseEntity.ok("SUCCESS");
        }

        return ResponseEntity.ok("FAILED");
    }

    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<List<User>> getAll() {
        
        List<User> users = authService.getAll();

        return ResponseEntity.ok(users);
    }
    
}
