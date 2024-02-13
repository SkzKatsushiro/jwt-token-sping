package com.test.security.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "test-app-user", schema = "application-security")
public class AppUser extends User {

    @Id
    @GeneratedValue
    Integer id;

    String firstName;
    String lastName;
    String email;

    public AppUser(
        String username, 
        String password, 
        Collection<? extends GrantedAuthority> authorities) {
		super(username, password, true, true, true, true, authorities);
	}
}