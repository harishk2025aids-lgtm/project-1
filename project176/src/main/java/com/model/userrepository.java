package com.model;

import org.springframework.data.jpa.repository.JpaRepository;



public interface userrepository extends JpaRepository<user, String> {
}