package com.example.api_crud_users_SOLID.Services;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.Exception.EmailAlreadyExistsException;
import com.example.api_crud_users_SOLID.Repository.UserRepository;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import com.example.api_crud_users_SOLID.ValueObjects.UserName;
import com.example.api_crud_users_SOLID.dto.UserRequest;
import com.example.api_crud_users_SOLID.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    private final UserRepository userRepository;

    public UserCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(UserRequest request) {
        Email email = new Email(request.email());
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User(request.id(),new UserName(request.name()),email);
        return toResponse(userRepository.create(user));
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
