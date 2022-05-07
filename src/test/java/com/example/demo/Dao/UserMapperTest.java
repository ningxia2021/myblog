package com.example.demo.Dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void addUser() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("14");
        userMapper.addUser(user);
        System.out.println("==============================");
        System.out.println(user);
        System.out.println("==============================");
    }

    @Test
    void selectUserAll() {
        userMapper.selectUserAll();
    }

    @Test
    void selectUserByUsername() {
        User user = userMapper.selectUserByUsername("gaoh");
        System.out.println(user);
    }

    @Test
    void selectUserById() {
        User user = userMapper.selectUserById(4);
        System.out.println("==============================");
        System.out.println(user);
        System.out.println("==============================");
    }
}