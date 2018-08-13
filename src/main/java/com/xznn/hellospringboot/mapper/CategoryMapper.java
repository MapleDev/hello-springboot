package com.xznn.hellospringboot.mapper;


import com.xznn.hellospringboot.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int add(Category category);

    List<Category> findAll();

    Category get(int id);

    int delete(int id);

    int update(Category category);

}
