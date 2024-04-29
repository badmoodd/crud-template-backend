package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.dtos.AuthRequest;
import com.amaizing.crudtemplate.models.dtos.JwtResponse;
import com.amaizing.crudtemplate.models.dtos.UserDto;
import com.amaizing.crudtemplate.models.dtos.UserSignUpRequest;
import com.amaizing.crudtemplate.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<String> createUser(@RequestBody UserSignUpRequest signUpRequest) {
        return authService.createUser(signUpRequest);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest.email(), authRequest.password());
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(HttpServletRequest request) {
        return authService.getUser(request);
    }



}
