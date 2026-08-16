package com.example.api_crud_users_SOLID.dto;

import com.example.api_crud_users_SOLID.ValueObjects.Email;
import com.example.api_crud_users_SOLID.ValueObjects.UserName;

public record UserResponse(
        UserName name,
        Email email
) {}
