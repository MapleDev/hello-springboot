package com.xznn.hellospringboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xznn.hellospringboot.dao.CategoryDAO;
import com.xznn.hellospringboot.mapper.CategoryMapper;
import com.xznn.hellospringboot.mapper.CategoryMapperAnnotation;
import com.xznn.hellospringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryMapperAnnotation categoryMapperAnnotation;

    @RequestMapping("/listCategory")
    public String listCategory(Model model) {
        model.addAttribute("cs", categoryDAO.findAll());
        return "listCategory";
    }

    @RequestMapping("/listCategoryByMybatis")
    public String listCategoryByMybatis(Model model) {
        model.addAttribute("cs", categoryMapper.findAll());
        return "listCategory";
    }

    @RequestMapping("/listCategoryByMybatisAnnotation")
    public String listCategoryByMybatisAnnotation(Model model) {
        model.addAttribute("cs", categoryMapperAnnotation.findAll());
        return "listCategory";
    }

    @RequestMapping("/listCategoryPageJPA")
    public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page = categoryDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "listCategoryJPA";
    }

    @RequestMapping("/listCategoryForThymeleaf")
    public String listCategoryForThymeleaf(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        List<Category> cs = categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        model.addAttribute("page", page);
        return "listCategoryForThymeleaf";
    }

    @RequestMapping("/editCategory")
    public ModelAndView editCategory(int id) {
        return new ModelAndView("editCategory", "category", categoryMapper.get(id));
    }

    @RequestMapping("/deleteCategory")
    public ModelAndView deleteCategory(int id) {
        int delete = categoryMapper.delete(id);
        System.out.println("delete = [" + delete + "]");

        return new ModelAndView("redirect:/listCategoryForThymeleaf");
    }

    @RequestMapping("/updateCategory")
    public ModelAndView updateCategory(Category category) {
        int update = categoryMapper.update(category);
        System.out.println("update = [" + update + "]");

        return new ModelAndView("redirect:/listCategoryForThymeleaf");
    }

    @RequestMapping("/addCategory")
    public ModelAndView addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryMapper.add(category);

        return new ModelAndView("redirect:/listCategoryForThymeleaf");
    }
}
