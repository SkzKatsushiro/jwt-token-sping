package com.test.security.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtConfig {

    @Value("${jwt.secret}")
    String secret;

    @Value("${jwt.algorithm}")
    String algorithm;

    @Bean
     SecretKeySpec secretKeySpec() {
        return new SecretKeySpec(
            secret.getBytes(),
            algorithm);
    }
}
