package com.example.api_crud_users_SOLID.Services;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.Repository.UserRepository;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import com.example.api_crud_users_SOLID.dto.FindUserRequest;
import com.example.api_crud_users_SOLID.dto.FindUserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserFinder {

    private final UserRepository userRepository;

    public UserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public FindUserResponse find(String email) {
        FindUserRequest request = new FindUserRequest(email);
        Email userEmail = new Email(request.email());

        User user = userRepository.findByEmail(userEmail);

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
