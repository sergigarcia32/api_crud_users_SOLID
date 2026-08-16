package com.example.api_crud_users_SOLID.dto;

public record UserRequest(
        Long id,
        String name,
        String email
) {}
