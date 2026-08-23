package com.example.api_crud_users_SOLID.Services;

import com.example.api_crud_users_SOLID.persistence.Repository.UserRepository;
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
