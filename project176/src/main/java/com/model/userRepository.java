package com.model;

import org.springframework.data.jpa.repository.JpaRepository;



public interface userRepository extends JpaRepository<user, String> {
}