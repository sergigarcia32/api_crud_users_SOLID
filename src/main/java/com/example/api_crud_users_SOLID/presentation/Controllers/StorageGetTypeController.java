package com.example.api_crud_users_SOLID.presentation.Controllers;

import com.example.api_crud_users_SOLID.Services.GetStorageType;
import com.example.api_crud_users_SOLID.presentation.Controllers.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StorageGetTypeController {
    private final GetStorageType getStorage;

    public StorageGetTypeController( GetStorageType getStorage) {
        this.getStorage = getStorage;
    }

    @GetMapping("/getStorageType")
    public ResponseEntity<?> getStorageType() {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.getStorage.getStorage());

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
