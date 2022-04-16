package com.redis;

import com.redis.entity.User;
import com.redis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {

        System.out.println("12334");
        List<User> all = userService.findAll();
        for(User user:all){
            System.out.println(user);
        }
        System.out.println("0000000000000000000");

        for(User user:all){
            System.out.println(user);
        }

    }

}
