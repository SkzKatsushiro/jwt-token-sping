package com.test.security.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtServiceTest {

    @Mock
    KeyPair keyPair;

    @InjectMocks
    JwtService jwtService;

    @Test
    void testExtractUsername() {

    }

    @Test
    void extractAll() throws NoSuchAlgorithmException {
        var secret = "your-512-bit-secret-1";

        // Initialize the MAC object with the secret key
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(),
         "HmacSHA256");
        
        when(keyPair.getPrivate()).thenReturn((PrivateKey) secretKey);

        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXNlcm5hbWUiOiJKb2huIERvZSIsImFkbWluIjp0cnVlLCJhdXRob3JpdGllcyI6WyJBZG1pbiIsIlRlc3QiXSwiaWF0IjoxNTE2MjM5MDIyfQ.Jc5tILjIycDnamgUIuLgSN9ySVAmdYZBnjG7Bl6B1uc";

        var claims = jwtService.extractAll(token, secretKey);

        assertNotNull(claims);
    }
}
