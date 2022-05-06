package com.example.demo.Dao;

import com.example.demo.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@SpringBootTest
class BlogMapperTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    void addBlog() {
        Blog blog = new Blog();
        blog.setBlogId(2);
        blog.setTitle("Test-Mybatis-Function");
        blog.setContent("第二次尝试测试");
        blog.setUserId(2);
        blogMapper.addBlog(blog);
    }

    @Test
    void selectAllBlog() {
        List<Blog> blogs = blogMapper.selectAllBlog();
        blogs.forEach(System.out::println);
    }

    @Test
    void selectByBlogId() {
        Blog blog = blogMapper.selectByBlogId(1);
        System.out.println(blog);
    }

    @Test
    void deleteByBlogId() {
        blogMapper.deleteByBlogId(1);
    }
}