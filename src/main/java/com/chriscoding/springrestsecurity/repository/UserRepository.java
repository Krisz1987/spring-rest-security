package com.chriscoding.springrestsecurity.repository;

import com.chriscoding.springrestsecurity.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);

    Optional<User> findByName(String name);
}
