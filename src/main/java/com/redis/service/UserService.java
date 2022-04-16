package com.redis.service;

import com.redis.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    void delete(String id);
}
