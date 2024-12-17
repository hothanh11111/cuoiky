package com.example.store_sell_laptop.repository;

import com.example.store_sell_laptop.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
