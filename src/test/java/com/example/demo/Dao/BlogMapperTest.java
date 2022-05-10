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
// blogId 为auto_increment 此处无需手动设置
        blog.setTitle("理想国摘录");
        blog.setContent("第三卷 教育中的艺术\n" +
                "\n" +
                "1、在年少的时候，喜欢善良、厌恶邪恶，其本身就已经单纯的像是自然生长一样，不需要再加以抉择；年长之后，思想与能力得到发展，对善恶的认识，就会明白的像手掌里的东西数数一样。\n" +
                "2、音乐上的奢华，使人放纵；生活上的奢华，使人生病。而简朴的音乐，能够产生美德；简单而实在的体育训练，能够有益健康。\n" +
                "3、所谓统治者，指的是掌握最高权力的人。他们对外能够抵御强悍的敌人，对内能够保护人民，这样国家才能像磐石那样安稳。\n");
        blog.setPostTime(new Timestamp(System.currentTimeMillis()));
        blog.setUserId(5);
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
        List<Blog> blog = blogMapper.selectByUserId(4);
        System.out.println(blog);
    }
}