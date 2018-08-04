package com.xznn.hellospringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class TimeController {

    @RequestMapping("/time")
    public String hello(Model model) {
        model.addAttribute("time", DateFormat.getInstance().format(new Date()));
        if (true) {
            throw new RuntimeException("I'm a RuntimeException...");
        }
        return "time";
    }
}
