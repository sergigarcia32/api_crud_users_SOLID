package com.example.api_crud_users_SOLID.presentation.Controllers;

import com.example.api_crud_users_SOLID.Services.UserRemover;
import com.example.api_crud_users_SOLID.presentation.Controllers.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserDeleteController {

    private final UserRemover userRemover;

    public UserDeleteController(UserRemover userRemover) {
        this.userRemover = userRemover;
    }

    @DeleteMapping("delete/{email}")
    public ResponseEntity<?> delete(@PathVariable String email) {

        try {
            this.userRemover.remove(email);

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();

        } catch (RuntimeException e) {

            ErrorResponse error = new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage()
            );

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error);
        }
    }
}
