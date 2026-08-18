package com.example.api_crud_users_SOLID.Services;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.Repository.UserRepository;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import com.example.api_crud_users_SOLID.dto.FindUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserRemover {
    private final UserRepository userRepository;

    public UserRemover(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void remove(String email) {
        FindUserRequest request = new FindUserRequest(email);
        Email userEmail = new Email(request.email());

        userRepository.remove(userEmail);
    }
}
