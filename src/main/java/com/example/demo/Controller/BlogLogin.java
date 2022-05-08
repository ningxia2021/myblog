package com.example.demo.Controller;

import com.example.demo.Dao.UserMapper;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping
//@Slf4j
public class BlogLogin {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/bloglogin")
    public String blogLogin(Integer userId , String username , String password) {
        User user = userMapper.selectUserById(userId);
        if (user.getUsername() == username && user.getPassword() == password) {
            return "blog_list";
        }

        return "../Error/error_loginError";

    }
}
