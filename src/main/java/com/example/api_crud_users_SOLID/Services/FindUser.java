package com.example.api_crud_users_SOLID.Services;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.Exception.EmailAlreadyExistsException;
import com.example.api_crud_users_SOLID.Repository.UserRepository;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import com.example.api_crud_users_SOLID.ValueObjects.UserName;
import com.example.api_crud_users_SOLID.dto.FindUserRequest;
import com.example.api_crud_users_SOLID.dto.FindUserResponse;
import com.example.api_crud_users_SOLID.dto.UserRequest;
import com.example.api_crud_users_SOLID.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class FindUser {

    private final UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public FindUserResponse find(FindUserRequest request) {
        Email email = new Email(request.email());

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return toResponse(user);
    }

    private FindUserResponse toResponse(User user) {
        return new FindUserResponse(
                user.getName(),
                user.getEmail()
        );
    }
}
