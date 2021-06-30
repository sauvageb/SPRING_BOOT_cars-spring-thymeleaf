package com.example.carspring.service;

import com.example.carspring.model.User;

public interface UserServiceImpl {
    User findByUsername(String username);
}