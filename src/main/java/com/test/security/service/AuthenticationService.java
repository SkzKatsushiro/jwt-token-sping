package com.test.security.service;

import org.springframework.stereotype.Service;

import com.test.security.dto.AuthenticateRequest;
import com.test.security.dto.AuthenticationResponse;
import com.test.security.dto.RegisterRequest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    public AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }

}
