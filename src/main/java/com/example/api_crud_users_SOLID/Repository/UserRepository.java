package com.example.api_crud_users_SOLID.Repository;

import com.example.api_crud_users_SOLID.Entity.User;
import com.example.api_crud_users_SOLID.ValueObjects.Email;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    String getStorageType();
    boolean existsByEmail(Email email);
    User create(User user);
    void remove(Email email);
    User findByEmail(Email email);


}
