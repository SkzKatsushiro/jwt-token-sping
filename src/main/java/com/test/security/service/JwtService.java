package com.test.security.service;

import java.security.KeyPair;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtService {

    KeyPair keyPair;

    public String extractUsername(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserName'");
    }

    public Claims extractAll(String token, SecretKeySpec secretKey) {
            return Jwts
                .parser()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
