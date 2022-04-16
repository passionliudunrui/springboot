package com.redis.dao;

import com.redis.entity.User;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
