package com.example.api_crud_users_SOLID.Repository;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserSaveInMemory implements UserRepository{
    private final Map<Email, User> users = new HashMap<>();

    public User create(User user) {

        users.put(user.getEmail(), user);

        return user;
    }

    public boolean existsByEmail(Email email){
        return users.containsKey(email);
    }

    public User findByEmail(Email email) {
        return users.get(email);
    }

}
