package com.example.demo.Controller;

import com.example.demo.Dao.BlogMapper;
import com.example.demo.Dao.UserMapper;
import com.example.demo.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping
public class BlogListController {

    @Resource
    BlogMapper blogMapper;

    @GetMapping("/blog_list.html")
    public String bloglist(Model model){
        List<Blog> blogs = blogMapper.selectAllBlog();
        model.addAttribute("blogs",blogs);
        return "blog_list";
    }

}
