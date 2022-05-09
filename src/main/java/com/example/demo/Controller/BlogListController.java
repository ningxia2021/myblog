package com.example.demo.Controller;

import com.example.demo.Dao.BlogMapper;
import com.example.demo.common.util;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class BlogListController {

    @Resource
    BlogMapper blogMapper;

//    这里主要就是为了渲染
    @GetMapping("/blog_list.html")
    public String bloglist(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html,charset=utf-8");
        //        检查用户是否已经登录
        User user = util.checkLoginStatus(request);
        if (user == null){
            response.getWriter().write("当前用户未登录! 请登录...");
            response.sendRedirect("blog_login.html");
        }
//        行文至此 肯定是有sessionId的
        List<Blog> blogs = blogMapper.selectByUserId(user.getUserId());
        model.addAttribute("blogs", blogs);
        model.addAttribute("username",user.getUsername());
        return "blog_list";
    }
}
