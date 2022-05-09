package com.example.demo.common;

import com.example.demo.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class util {
    public static User checkLoginStatus(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null){
            return null;
        }
        User user = (User) session.getAttribute("USER");
        if (user == null){
            return null;
        }
        return user;
    }
}
