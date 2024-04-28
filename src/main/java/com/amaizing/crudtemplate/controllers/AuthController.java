package com.amaizing.crudtemplate.controllers;

import com.amaizing.crudtemplate.models.dtos.AuthRequest;
import com.amaizing.crudtemplate.models.dtos.JwtResponse;
import com.amaizing.crudtemplate.models.dtos.UserSignUpRequest;
import com.amaizing.crudtemplate.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody UserSignUpRequest signUpRequest) {
        return authService.createUser(signUpRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest.email(), authRequest.password());
    }



}
