package com.example.api_crud_users_SOLID.Services;

import com.example.api_crud_users_SOLID.Repository.UserRepository;
import com.example.api_crud_users_SOLID.dto.FindUserResponse;
import org.springframework.stereotype.Service;

@Service
public class GetStorageType {
    private final UserRepository userRepository;

    public GetStorageType(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getStorage() {
        return this.userRepository.getStorageType();
    }
}
