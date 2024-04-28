package com.amaizing.crudtemplate.services.impl;

import com.amaizing.crudtemplate.models.User;
import com.amaizing.crudtemplate.models.dtos.JwtResponse;
import com.amaizing.crudtemplate.models.dtos.UserSignUpRequest;
import com.amaizing.crudtemplate.models.enums.UserRole;
import com.amaizing.crudtemplate.repositories.UserRepository;
import com.amaizing.crudtemplate.services.AuthService;
import com.amaizing.crudtemplate.services.exceptions.UserAuthenticationException;
import com.amaizing.crudtemplate.services.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImp implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<JwtResponse> authenticate(String email, String password) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(email, password));

            User user = userRepository.findById(email).orElseThrow();
            String jwt = jwtTokenProvider.generateToken(user);
            var expirationTime = jwtTokenProvider
                    .getAllClaimsFromToken(jwt).getBody().getExpiration();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
            var tokenResponse = new JwtResponse(jwt, expirationTime);

            return ResponseEntity.ok().headers(httpHeaders).body(tokenResponse);
        } catch (BadCredentialsException ex) {
            log.info(ex.getMessage());
            throw new UserAuthenticationException("Wrong username or password");
        }
    }

    @Override
    public ResponseEntity<String> createUser(UserSignUpRequest signUpRequest) {
        var optUser = userRepository.findById(signUpRequest.getEmail());

        if (optUser.isEmpty()) {
            var userToSave = new User();
            userToSave.setEmail(signUpRequest.getEmail());
            userToSave.setUsername(signUpRequest.getUsername());
            userToSave.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            userToSave.setRole(UserRole.ROLE_USER);
            userRepository.save(userToSave);
            String responseMessage = String.format("Created user with email '%s'", userToSave.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        } else {
            String responseMessage = String.format("User with email '%s' already exists", signUpRequest.getEmail());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(responseMessage);
        }

    }
}