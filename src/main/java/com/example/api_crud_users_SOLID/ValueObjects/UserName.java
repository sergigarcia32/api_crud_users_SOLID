package com.example.api_crud_users_SOLID.ValueObjects;

public record UserName(String value) {

    public UserName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
