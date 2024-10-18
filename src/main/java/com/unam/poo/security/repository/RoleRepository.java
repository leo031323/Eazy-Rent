package com.unam.poo.security.repository;

import java.util.Optional;

import com.unam.poo.security.modelo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unam.poo.security.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleName(RoleName roleName);
}