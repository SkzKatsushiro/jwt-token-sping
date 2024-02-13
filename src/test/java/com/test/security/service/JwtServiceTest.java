package com.test.security.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

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

    //@Test
    void testExtractUsername() {

    }

    @Test
    void extractAll() throws NoSuchAlgorithmException {
        var secret = "This code will generate a random text string of length 256 characters consisting of uppercase letters, lowercase letters, and digits. You can adjust the characters used or include additional characters if needed.";

        // Initialize the MAC object with the secret key
        SecretKeySpec secretKey = new SecretKeySpec(
            secret.getBytes(),
         "HmacSHA256");

        var token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXNlcm5hbWUiOiJKb2huIERvZSIsImFkbWluIjp0cnVlLCJhdXRob3JpdGllcyI6WyJBZG1pbiIsIlRlc3QiXSwiaWF0IjoxNTE2MjM5MDIyfQ.jzK8LAgFyBbPTAv519sjxPWch_vhgxIOAzionov8GOQ";

        var claims = jwtService.extractAll(token, secretKey);

        assertNotNull(claims);
    }
}
