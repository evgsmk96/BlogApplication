package com.example.blogapplication.controllers;

import com.example.blogapplication.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repo.PostRepository;

@Controller
public class BlogController {

    private PostRepository postRepo;

    @GetMapping("/blog")
    public String blogMain (Model model) {
        Iterable<Posts> posts = postRepo.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title","Главная страница");
        return "blog-main";
    }

    @GetMapping("/about")
    public String aboutUs (Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }
}
