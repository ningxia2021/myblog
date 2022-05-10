package com.example.demo.Controller;

import com.example.demo.common.util;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class edit {

    @GetMapping("blog_edit.html")
    public String edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        User user = util.checkLoginStatus(request);
        if (user == null) {
            String html = "<h3>当前未登录, 不能发布文章</h3>";
            response.getWriter().write(html);
            return null;
        }
        return "blog_edit";
    }
}
