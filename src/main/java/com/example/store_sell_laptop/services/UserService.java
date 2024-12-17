package com.example.store_sell_laptop.services;

import com.example.store_sell_laptop.dto.UserDto;
import com.example.store_sell_laptop.models.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
