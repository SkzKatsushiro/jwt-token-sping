package com.test.security.domain;

import org.springframework.security.core.userdetails.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test-app-user", schema = "application-security")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppUser extends User {

    @Id
    @GeneratedValue
    Integer id;

    String firstName;
    String lastName;
    String email;
}