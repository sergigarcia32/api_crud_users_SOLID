package com.example.api_crud_users_SOLID.Entity;

import com.example.api_crud_users_SOLID.ValueObjects.Email;
import com.example.api_crud_users_SOLID.ValueObjects.UserName;

public class User {

    private Long id;
    private UserName name;
    private Email email;

    public User() {
    }

    public User(Long id, UserName name, Email email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserName getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
}
