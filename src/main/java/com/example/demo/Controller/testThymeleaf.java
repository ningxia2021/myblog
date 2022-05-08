package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试 Thymeleaf 可用
 */
@Controller

public class testThymeleaf {

    @GetMapping("/test")
    public String hello(Model model){
        //存入数据
        model.addAttribute("msg","测试 Thymeleaf 可用");
        return "hello";
    }
}
