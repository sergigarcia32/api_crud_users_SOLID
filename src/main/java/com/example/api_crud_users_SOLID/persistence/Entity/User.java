package com.example.api_crud_users_SOLID.persistence.Entity;

import com.example.api_crud_users_SOLID.persistence.Entity.ValueObjects.Email;
import com.example.api_crud_users_SOLID.persistence.Entity.ValueObjects.UserName;

public class User {

    private UserName name;
    private Email email;

    public User() {
    }

    public User(UserName name, Email email) {
        this.name = name;
        this.email = email;
    }

    public UserName getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

}
