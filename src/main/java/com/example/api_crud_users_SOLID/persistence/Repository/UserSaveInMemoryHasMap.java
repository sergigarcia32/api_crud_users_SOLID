package com.example.api_crud_users_SOLID.persistence.Repository;

import com.example.api_crud_users_SOLID.persistence.Entity.User;
import com.example.api_crud_users_SOLID.persistence.Entity.ValueObjects.Email;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(
        name = "user.storage",
        havingValue = "HASH_MAP"
)
public class UserSaveInMemoryHasMap implements UserRepository{
    private final Map<Email, User> users = new HashMap<>();

    public User create(User user) {

        users.put(user.getEmail(), user);

        return user;
    }

    public void remove(Email email) {
        users.remove(email);
    }

    @Override
    public String getStorageType() {
        return "Hash Map";
    }

    public boolean existsByEmail(Email email){
        return users.containsKey(email);
    }

    public User findByEmail(Email email) {
        return users.get(email);
    }

}
