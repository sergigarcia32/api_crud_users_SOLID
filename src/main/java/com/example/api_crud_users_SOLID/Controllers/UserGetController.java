package com.example.api_crud_users_SOLID.Controllers;

import com.example.api_crud_users_SOLID.Exception.EmailAlreadyExistsException;
import com.example.api_crud_users_SOLID.Services.FindUser;
import com.example.api_crud_users_SOLID.Services.UserCreator;
import com.example.api_crud_users_SOLID.dto.ErrorResponse;
import com.example.api_crud_users_SOLID.dto.FindUserRequest;
import com.example.api_crud_users_SOLID.dto.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/getUser")
public class UserGetController {
    private final FindUser findUser;

    public UserGetController(FindUser findUser) {
        this.findUser = findUser;
    }

    @GetMapping
    public ResponseEntity<?> find(
            @RequestBody FindUserRequest request) {

        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.findUser.find(request));

        } catch (RuntimeException e) {

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
