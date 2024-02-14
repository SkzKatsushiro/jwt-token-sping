package com.test.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.security.domain.AppUser;
import com.test.security.dto.AuthenticateRequest;
import com.test.security.dto.AuthenticationResponse;
import com.test.security.dto.RegisterRequest;
import com.test.security.repository.AppUserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    AppUserRepository appUserRepository;
    PasswordEncoder passwordEncoder;
    JwtService jwtService;
    AuthenticationManager authenticationManager;
    
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        
        var user = AppUser
        .builder()
         .username(registerRequest.getUserName())
         .password(registerRequest.getPassword())
         .firstName(registerRequest.getFirstName())
         .lastName(registerRequest.getLastName())
        .build();

        user = appUserRepository.save(user);
        
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
        .builder()
            .token(jwtToken)
        .build();
    }

    public AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                authenticateRequest.getUserName(), 
                authenticateRequest.getPassword()));
                
        var user = appUserRepository
        .findByUsername(authenticateRequest.getUserName())
        .orElseThrow();
        
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
        .builder()
            .token(jwtToken)
        .build();
    }
}
