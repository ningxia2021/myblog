package com.example.demo.Controller;

import com.example.demo.Dao.BlogMapper;
import com.example.demo.common.util;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BlogDel {
    @Resource
    private BlogMapper blogMapper;
    @GetMapping("/del")
    public void del(HttpServletResponse response , HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = util.checkLoginStatus(request);
        if (user == null){
            response.getWriter().write("<h1>当前处于未登录状态 请登录</h2>");
            response.sendRedirect("/login");
        }
        String blogId = request.getParameter("blogId");
        int id = Integer.parseInt(blogId);
        blogMapper.deleteByBlogId(id);
        response.sendRedirect("blog_list.html");
    }
}
