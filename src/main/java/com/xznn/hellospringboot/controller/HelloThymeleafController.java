package com.xznn.hellospringboot.controller;

import com.xznn.hellospringboot.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloThymeleafController {

    @RequestMapping("/helloThymeleaf")
    public String helloThymeleaf(Model model) {
        model.addAttribute("name", "Thymeleaf");

        String htmlContent = "<p style='color:red'> 红色文字</p>";
        model.addAttribute("htmlContent", htmlContent);

        Product currentProduct = new Product(5, "product e", 200);
        model.addAttribute("currentProduct", currentProduct);

//        boolean testBoolean = true;
        boolean testBoolean = false;
        model.addAttribute("testBoolean", testBoolean);

        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1, "product a", 50));
        ps.add(new Product(2, "product b", 100));
        ps.add(new Product(3, "product c", 150));
        ps.add(new Product(4, "product d", 200));
        ps.add(currentProduct);
        ps.add(new Product(6, "product f", 200));
        ps.add(new Product(7, "product g", 200));
        model.addAttribute("ps", ps);

        Date now = new Date();
        model.addAttribute("now", now);

        return "HelloThymeleaf";
    }
}
