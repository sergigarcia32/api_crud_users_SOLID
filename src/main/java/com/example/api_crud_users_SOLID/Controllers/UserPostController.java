package com.example.api_crud_users_SOLID.Controllers;

import com.example.api_crud_users_SOLID.Exception.EmailAlreadyExistsException;
import com.example.api_crud_users_SOLID.Services.UserCreator;
import com.example.api_crud_users_SOLID.dto.ErrorResponse;
import com.example.api_crud_users_SOLID.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserPostController {

    private final UserCreator userCreator;

    public UserPostController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody UserRequest request) {

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.userCreator.create(request));

        } catch (EmailAlreadyExistsException e) {

            ErrorResponse error = new ErrorResponse(
                    HttpStatus.CONFLICT.value(),
                    e.getMessage()
            );

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(error);
        }
    }
}
