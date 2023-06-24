package com.example.dream.service;

import com.example.dream.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpl {
    List<Users> listUsers();
    Users addUser(Users user);
    Optional<Users> getById(Long id);
    Users updateUser(Long id, Users users);
}
