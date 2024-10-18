package com.unam.poo.security.service;

import java.util.Optional;

import com.unam.poo.security.modelo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unam.poo.security.enums.RoleName;
import com.unam.poo.security.repository.RoleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    RoleRepository roleRepository;
    
    public Optional<Role> getByRolNombre(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }
    
    public void save(Role role){
        roleRepository.save(role);
    }
}