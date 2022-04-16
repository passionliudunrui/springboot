package com.redis;

import com.redis.entity.User;
import com.redis.service.UserService;
import org.apache.ibatis.cache.Cache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    public void findAll() {

        System.out.println("12334");
        List<User> all = userService.findAll();
        for(User user:all){
            System.out.println(user);
        }
        System.out.println("0000000000000000000");

        List<User>all2=userService.findAll();
        for(User user:all2){
            System.out.println(user);
        }

    }

    @Test
    public void findById(){
        User user1 = userService.findById("2");

        System.out.println(user1);

        User user2 = userService.findById("4");

        System.out.println(user2);



    }

    @Test
    public void delete(){
        userService.delete("2");

    }




}
