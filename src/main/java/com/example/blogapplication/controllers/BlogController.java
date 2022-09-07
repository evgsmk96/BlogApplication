package com.example.blogapplication.controllers;

import com.example.blogapplication.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.blogapplication.repo.PostRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepo;

    @GetMapping("/blog")
    public String blogMain (Model model) {
        Iterable<Posts> posts = postRepo.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title","Главная страница");
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogAddPost (@RequestParam String title, @RequestParam String anons, @RequestParam String fulltext, Model model) {
        Posts post = new Posts(title, anons, fulltext);
        postRepo.save(post);
        return "redirect:/blog";
    }

}
