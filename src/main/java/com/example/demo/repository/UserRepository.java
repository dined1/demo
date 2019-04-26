package com.example.demo.repository;

import com.example.demo.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SystemUser, String> {
}
