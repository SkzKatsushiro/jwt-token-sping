package com.test.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.security.domain.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

  public Optional<AppUser> findByUsername(String username);
}