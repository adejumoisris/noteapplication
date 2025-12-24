package com.example.noteapplication.repository;

import com.example.noteapplication.enums.AppRole;
import com.example.noteapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
