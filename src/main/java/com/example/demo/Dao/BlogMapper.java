package com.example.demo.Dao;

import com.example.demo.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
//  新增一个博客
    void addBlog(Blog blog);

//  获取到所有博客列表
    List<Blog> selectAllBlog();

//  根据博客id获取指定博客
    Blog selectByBlogId(int id);

//  根据博客id删除博客
    void deleteByBlogId(int id);
}
