package com.example.api_crud_users_SOLID.presentation.Controllers;

import com.example.api_crud_users_SOLID.Services.UserFinder;
import com.example.api_crud_users_SOLID.presentation.Controllers.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserGetController {
    private final UserFinder findUser;

    public UserGetController(UserFinder findUser) {
        this.findUser = findUser;
    }

    @GetMapping("/getUser/{email}")
    public ResponseEntity<?> find(@PathVariable String email) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.findUser.find(email));

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
