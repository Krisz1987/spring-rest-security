package com.chriscoding.springrestsecurity.repository;

import com.chriscoding.springrestsecurity.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
