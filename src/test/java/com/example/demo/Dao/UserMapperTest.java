package com.example.demo.Dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    void addUser() {
        User user = new User();
        user.setUsername("一条大菜狗");
        user.setPassword("123");
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
        User user = userMapper.selectUserById(0);
        System.out.println("==============================");
        System.out.println(user);
        System.out.println("==============================");
    }
}