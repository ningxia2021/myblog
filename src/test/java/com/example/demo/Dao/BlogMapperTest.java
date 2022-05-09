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
        blog.setTitle("Test1");
        blog.setContent("当所有 Tomcat 需要往 Session 中写数据时，都往 Redis 中写，当所有 Tomcat 需要读数据时，都从 Redis 中读。这样，不同的服务就可以使用相同的 Session 数据了。\n" +
                "这样的方案，可以由开发者手动实现，即手动往 Redis 中存储数据，手动从 Redis 中读取数据，相当于使用一些 Redis 客户端工具来实现这样的功能，毫无疑问，手动实现工作量还是蛮大的。\n" +
                "一个简化的方案就是使用 Spring Session 来实现这一功能，Spring Session 就是使用 Spring 中的代理过滤器，将所有的 Session 操作拦截下来，自动的将数据 同步到 Redis 中，或者自动的从 Redis 中读取数据。\n" +
                "对于开发者来说，所有关于 Session 同步的操作都是透明的，开发者使用 Spring Session，一旦配置完成后，具体的用法就像使用一个普通的 Session 一样。");
        blog.setUserId(1);
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

    @Test
    void selectByUserId() {
        List<Blog> blog = blogMapper.selectByUserId(1);
        System.out.println(blog);
    }
}