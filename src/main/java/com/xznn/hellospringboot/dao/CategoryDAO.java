package com.xznn.hellospringboot.dao;


import com.xznn.hellospringboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

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


    @Override
    List<Category> findAll();
}
