package com.test.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.security.domain.AppUser;


interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);
}