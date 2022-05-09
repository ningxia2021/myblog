package com.example.demo.Controller;

import com.example.demo.Dao.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping
public class BlogLogin {
    @Resource
    private UserMapper userMapper;

    @PostMapping("/login")
    public void blogLogin(User user1, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        提取参数
        String username = user1.getUsername();
        String password = user1.getPassword();
//        参数非空校验
        if (username == null || username.equals("")||password==null || password.equals("")){
            response.getWriter().write("用户名密码为空");
            return;
        }
        User user = userMapper.selectUserByUsername(username);
//        查询结果非空校验
        if (user==null) {
            response.getWriter().write("用户不存在！");
            return;
        }
//        密码验证
        if (!user.getPassword().equals(password)){
            response.getWriter().write("密码错误！");
            return;
        }
//        至此，说明登录成功
        HttpSession session = request.getSession(true);
        session.setAttribute("USER",user);
        response.getWriter().write("登录成功");
        response.sendRedirect("blog_list.html");
    }
}
