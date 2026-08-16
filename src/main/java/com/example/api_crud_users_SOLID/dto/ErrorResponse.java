package com.example.api_crud_users_SOLID.dto;

public record ErrorResponse(
        int code,
        String message
) {}
