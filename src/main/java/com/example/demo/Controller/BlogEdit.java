package com.example.demo.Controller;

import com.example.demo.Dao.BlogMapper;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@Controller
public class BlogEdit {
    @Resource
    private BlogMapper blogMapper;
    @PostMapping("/blog_edit")
    public void blogedit(String title, String content, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        User user = (User)session.getAttribute("USER");
        if (title == null || "".equals(title) || content == null || "".equals(content)) {
            String html = "<h3>提交的title或者content不存在! 发布博客失败!</h3>";
            response.getWriter().write(html);
            return ;
        }
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blogMapper.addBlog(blog);
        response.sendRedirect("blog_list.html");
    }
}
