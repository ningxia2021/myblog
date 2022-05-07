package com.example.demo.Dao;

import com.example.demo.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;


@SpringBootTest
class BlogMapperTest {

    @Resource
    private BlogMapper blogMapper;

    @Test
    void addBlog() {
        Blog blog = new Blog();
//        blog.setBlogId(0);
        blog.setTitle("Test-Mybatis-Function");
        blog.setContent("第三次尝试测试");
        blog.setUserId(5);
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blogMapper.addBlog(blog);
    }

    @Test
    void selectAllBlog() {
        List<Blog> blogs = blogMapper.selectAllBlog();
        System.out.println("========================");
        blogs.forEach(System.out::println);
        System.out.println("========================");
    }

    @Test
    void selectByBlogId() {
        Blog blog = blogMapper.selectByBlogId(4);
        System.out.println(blog);
    }

    @Test
    void deleteByBlogId() {
        blogMapper.deleteByBlogId(1);
    }
}