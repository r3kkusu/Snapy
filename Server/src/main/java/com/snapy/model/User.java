package com.snapy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "User")
public class User {
    
    @Id
    @SequenceGenerator(
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = SEQUENCE,
        generator = "user_sequence"
    )
    @Column(
        name = "id", 
        updatable = false
    )
    private Long id;
    @Column(
        name = "username",
        unique = true,
        nullable = false
    )
    private String username;
    @Column(
        name = "email",
        unique = true,
        nullable = false
    )
    private String email;
    @Column(
        name = "password",
        nullable = false
    )
    private String password;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
