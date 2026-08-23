package com.example.api_crud_users_SOLID.presentation.Controllers.dto;

import com.example.api_crud_users_SOLID.persistence.Entity.ValueObjects.Email;
import com.example.api_crud_users_SOLID.persistence.Entity.ValueObjects.UserName;

public record UserResponse(
        UserName name,
        Email email
) {}
