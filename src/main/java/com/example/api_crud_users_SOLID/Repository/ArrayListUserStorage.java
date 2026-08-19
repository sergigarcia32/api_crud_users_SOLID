package com.example.api_crud_users_SOLID.Repository;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@ConditionalOnProperty(
        name = "user.storage",
        havingValue = "ARRAY_LIST"
)
public class ArrayListUserStorage implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void remove(Email email) {
        users.removeIf(user ->
                user.getEmail().equals(email)
        );
    }

    @Override
    public String getStorageType() {
        return "ArrayList";
    }

    @Override
    public boolean existsByEmail(Email email) {
        return users.stream()
                .anyMatch(user ->
                        user.getEmail().equals(email)
                );
    }

    @Override
    public User findByEmail(Email email) {

        return users.stream()
                .filter(user ->
                        user.getEmail().equals(email)
                )
                .findFirst()
                .orElse(null);
    }
}
