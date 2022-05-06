package com.example.demo.Dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
//    新建用户
    int addUser(User user);
//    查询用户
    List<User> selectUserAll();
}
