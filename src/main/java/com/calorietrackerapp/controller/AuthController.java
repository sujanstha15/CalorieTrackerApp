package com.calorietrackerapp.controller;

import com.calorietrackerapp.dto.UserRequestDTO;
import com.calorietrackerapp.dto.UserResponseDTO;
import com.calorietrackerapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO request){
        UserResponseDTO response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}
