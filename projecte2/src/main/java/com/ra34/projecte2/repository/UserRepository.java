package com.ra34.projecte2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra34.projecte2.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    
}
