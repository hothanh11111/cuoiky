package com.example.store_sell_laptop.repository;

import com.example.store_sell_laptop.models.User; // Import đúng lớp User
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}