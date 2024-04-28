package com.amaizing.crudtemplate.services;

import com.amaizing.crudtemplate.models.dtos.JwtResponse;
import com.amaizing.crudtemplate.models.dtos.UserSignUpRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<String> createUser(UserSignUpRequest signUpRequest);

    ResponseEntity<JwtResponse> authenticate(String email, String password);

}
