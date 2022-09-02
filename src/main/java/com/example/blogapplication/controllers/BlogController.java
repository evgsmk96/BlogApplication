package com.example.blogapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blogMain (Model model) {
    model.addAttribute("title","Главная страница");
    return "blog-main";
}

    @GetMapping("/about")
    public String aboutUs (Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }
}
