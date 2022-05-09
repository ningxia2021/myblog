package com.example.demo.Controller;

import com.example.demo.Dao.BlogMapper;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class BlogEdit {
    @Resource
    private BlogMapper blogMapper;
    @PostMapping("/blog_edit")
    public String blogedit(String title, String content, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("USER");
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blog.setUserId(user.getUserId());
        blogMapper.addBlog(blog);
        return "blog_list";
    }
}
