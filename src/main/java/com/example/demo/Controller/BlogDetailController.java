package com.example.demo.Controller;

import com.example.demo.Dao.BlogMapper;
import com.example.demo.model.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping
public class BlogDetailController {

    @Resource
    private BlogMapper blogMapper;

    /**
     * /blog_detail.html?blogId=1
     * 这个路径中的参数会随着映射关系一起带入
     * name代表参数的key，required=false代表参数不是必须要
     */
    @GetMapping("/blog_detail.html")
    public String BlogDetail(@RequestParam(name = "blogId" , required = false) Integer blogId,Model model) {
        if (blogId == null || blogId.equals("")){

        }
        Blog blog = blogMapper.selectByBlogId(blogId);
        model.addAttribute("blog",blog);
        return "blog_detail";
    }
}