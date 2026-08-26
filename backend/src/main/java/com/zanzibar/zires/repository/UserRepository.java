package com.zanzibar.zires.repository;

import com.zanzibar.zires.entity.User;  // ← Fixed import path
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // ← Added Repository annotation
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}