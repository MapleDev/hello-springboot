package com.xznn.hellospringboot.mapper;


import com.xznn.hellospringboot.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapperAnnotation {

//    int add(Category category);
//
//    int delete(int id);
//
//    int update(Category category);
//
//    Category get(int id);
//
//    List<Category> list();
//
//    List<Category> list(Page page);
//
//    int total();

    @Select("select * from category_")
    List<Category> findAll();

}
